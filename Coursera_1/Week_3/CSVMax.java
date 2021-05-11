/**
 * Find the highest (hottest) temperature in any number of files of CSV weather data chosen by the user.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
	private static String TEMPERATURE_COLUMN = "TemperatureF";
	private static String DATE_COLUMN = "DateUTC";
	private static String HUMIDITY_COLUMN = "Humidity";

	public CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord coldestRecord = null;

		for (CSVRecord record : parser) {
			double temperature = Double.parseDouble(record.get(TEMPERATURE_COLUMN));

			if (coldestRecord == null && temperature != -9999) {
				coldestRecord = record;
			} else {
				double coldestTemperature = Double.parseDouble(coldestRecord.get(TEMPERATURE_COLUMN));

				if (temperature < coldestTemperature && temperature != -9999) {
					coldestRecord = record;
				}
			}
		}

		return coldestRecord;
	}

	public File fileWithColdestTemperature() {
		DirectoryResource dr = new DirectoryResource();
		File file = null;
		CSVRecord coldestRecord = null;

		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currentRecord = coldestHourInFile(fr.getCSVParser());

			if (coldestRecord == null) {
				coldestRecord = currentRecord;
				file = f;
			} else {
				double coldestTemperature = Double.parseDouble(coldestRecord.get(TEMPERATURE_COLUMN));
				double currentTemperature = Double.parseDouble(currentRecord.get(TEMPERATURE_COLUMN));

				if (currentTemperature < coldestTemperature) {
					coldestRecord = currentRecord;
					file = f;
				}
			}
		}

		return file;
	}

	public void printAllRecordsInFile(CSVParser parser) {
		for (CSVRecord record : parser) {
			System.out.println(record.get(DATE_COLUMN) + " " + record.get(TEMPERATURE_COLUMN));
		}
	}

	public CSVRecord lowestHumidityInFile(CSVParser parser) {
		CSVRecord lowestHumidityRecord = null;

		for (CSVRecord record : parser) {
			String humidityStr = record.get(HUMIDITY_COLUMN);

			if (!humidityStr.equals("N/A")) {
				int humidity = Integer.parseInt(humidityStr);

				if (lowestHumidityRecord == null) {
					lowestHumidityRecord = record;
				} else {
					int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get(HUMIDITY_COLUMN));

					if (humidity < lowestHumidity) {
						lowestHumidityRecord = record;
					}
				}
			}
		}

		return lowestHumidityRecord;
	}


	public CSVRecord lowestHumidityInManyFiles() {
		DirectoryResource dr = new DirectoryResource();
		CSVRecord lowestHumidityRecord = null;

		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currentRecord = lowestHumidityInFile(fr.getCSVParser());

			if (lowestHumidityRecord == null) {
				lowestHumidityRecord = currentRecord;
			} else {
				int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get(HUMIDITY_COLUMN));
				int currentHumidity = Integer.parseInt(currentRecord.get(HUMIDITY_COLUMN));

				if (currentHumidity < lowestHumidity) {
					lowestHumidityRecord = currentRecord;
				}
			}
		}

		return lowestHumidityRecord;
	}

	public double averageTemperatureInFile(CSVParser parser) {
		double totalTemperature = 0;
		int recordCount = 0;

		for (CSVRecord record : parser) {
			double currentTemperature = Double.parseDouble(record.get(TEMPERATURE_COLUMN));

			if (currentTemperature != -9999) {
				totalTemperature += currentTemperature;
				recordCount++;
			}

		}

		return totalTemperature / recordCount;
	}

	public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
		double totalTemperature = 0;
		int recordCount = 0;

		for (CSVRecord record : parser) {
			int currentHumidity = Integer.parseInt(record.get(HUMIDITY_COLUMN));

			if (currentHumidity >= value) {
				double currentTemperature = Double.parseDouble(record.get(TEMPERATURE_COLUMN));

				if (currentTemperature != -9999) {
					totalTemperature += currentTemperature;
					recordCount++;
				}
			}
		}

		if (recordCount == 0) {
			return Double.NEGATIVE_INFINITY;
		} else {
			return totalTemperature / recordCount;
		}
	}
	public void tester(){
		FileResource fr = new FileResource();
		CSVRecord coldestRecord = coldestHourInFile(fr.getCSVParser());
		System.out.println("Coldest temperature was " + coldestRecord.get(TEMPERATURE_COLUMN) + " at " + coldestRecord.get(DATE_COLUMN));

		File file = fileWithColdestTemperature();
		System.out.println("Coldest day was in file " + file.getName());

		CSVParser parser = fr.getCSVParser();
		CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);
		System.out.println("Lowest Humidity was " + lowestHumidityRecord.get(HUMIDITY_COLUMN) + " at " + lowestHumidityRecord.get(DATE_COLUMN));

		CSVRecord lowestHumidityRecordInManyFile= lowestHumidityInManyFiles();
		System.out.println("Lowest Humidity was " + lowestHumidityRecordInManyFile.get(HUMIDITY_COLUMN) + " at " + lowestHumidityRecordInManyFile.get(DATE_COLUMN));

		double averageTemperature = averageTemperatureInFile(fr.getCSVParser());
		System.out.println("Average temperature in file is " + averageTemperature);

		double averageTemperatureWithHighHumidityInFile = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);

		if (averageTemperatureWithHighHumidityInFile == Double.NEGATIVE_INFINITY) {
			System.out.println("No temperature with that humidity");
		} else {
			System.out.println("Average temperature when high humidity is " + averageTemperatureWithHighHumidityInFile);
		}
	}
}
class Main{
	public static void main(String args[]){
      CSVMax object = new CSVMax();
      object.tester();
	}
}
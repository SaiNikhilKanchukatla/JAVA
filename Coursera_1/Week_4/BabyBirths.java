/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyBirths {
	public void printNames(FileResource fr) {
		fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}

	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
	}
	public long getRank(int year, String name, String gender)
	{

		int total=-1;
		//int numBoys=0,numGirls=0;
		FileResource fr = new FileResource();
		for(CSVRecord rec:fr.getCSVParser(false))
		{

			if(rec.get(1).equals(gender))
			{
				total+=1;
				if(rec.get(0).equals(name))
				{
					System.out.println("Rank is"+total);
					break;
				}


			}
		}
		return total;
	}

	public String getName(int year, int rank, String gender) {
		String name = "";
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser(false);

		for(CSVRecord record : parser) {
			long currRank = record.getRecordNumber();
			String currGender = record.get(1);
			String currName = record.get(0);

			if(currRank == rank && currGender.equals(gender)) {
				name = currName;
			}
		}

		if(name != "") {
			return name;
		}
		else {
			return "NO NAME";
		}
	}
	public void whatIsNameInYear(String name, int year, int newYear, String gender) {
		FileResource fr = new FileResource();
		FileResource newFr = new FileResource();
		CSVParser parserOld = fr.getCSVParser(false);
		CSVParser parserNew = newFr.getCSVParser(false);
		String newName = "";
		long popularity = 0;

		for(CSVRecord record : parserOld) {
			String currName = record.get(0);
			String currGender = record.get(1);

			if(currName.equals(name) && currGender.equals(gender)) {
				popularity = record.getRecordNumber();
			}
		}

		for(CSVRecord record : parserNew) {
			String currGender = record.get(1);
			long currPopularity = record.getRecordNumber();

			if(currGender.equals(gender) && popularity == currPopularity) {
				newName = record.get(0);
			}
		}

		System.out.println(name + " born in " + year + " would be " + newName + " if he/she was born in " + newYear);
	}

	public String yearOfHighestRank(String name, String gender) {
		long highestRank = 0;
		int yearOfHighestRank = -1;
		String fileName = "";
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			for(CSVRecord record : parser) {
				String currName = record.get(0);
				String currGender = record.get(1);
				if(currName.equals(name) && currGender.equals(gender)) {
					long currRank = record.getRecordNumber();
					if(highestRank == 0) {
						highestRank = currRank;
						fileName = f.getName();
					}
					else {
						if(highestRank > currRank) {
							highestRank = currRank;
							fileName = f.getName();
						}
					}
				}
			}
		}

		return fileName;
	}



	/*
	 * This method returns the average rank of a name in multiple files
	 */
	public double getAverageRank(String name, String gender) {
		DirectoryResource dr = new DirectoryResource();
		double rankTotal = 0.0;
		int howMany = 0;
		for(File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			for(CSVRecord record : parser) {
				String currName = record.get(0);
				String currGender = record.get(1);
				if(currName.equals(name) && currGender.equals(gender)){
					long currRank = record.getRecordNumber();
					rankTotal += (double)currRank;
					howMany += 1;
				}
			}
		}
		double avgRank = rankTotal / (double)howMany;
		return avgRank;
	}


	public int getTotalBirthsRankedHigher(int year, String name, String gender) {
		int numBorn = 0;
		long rank = getRank(year, name, gender);
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord record : parser) {
			int currBorn = Integer.parseInt(record.get(2));
			String currGender = record.get(1);
			long currRank = record.getRecordNumber();
			if(gender.equals(currGender) && rank > currRank) {
				numBorn += currBorn;
			}
		}
		return numBorn;
	}

	public void testing()
	{
		FileResource fr=new FileResource();
		printNames(fr);
		totalBirths(fr);
		getRank(1997,"Mason","M");
        getName(1997,5,"M");
        whatIsNameInYear("Manson",1997,2005,"M");
		System.out.println(yearOfHighestRank("Manson","M"));
		System.out.println(getAverageRank("Elgin","M"));
		System.out.println(getTotalBirthsRankedHigher(2000,"Erick","M"));

	}
}
class Main {
	public static void main(String args[]){
		BabyBirths babyBirths = new BabyBirths();
		babyBirths.testing();
	}
}
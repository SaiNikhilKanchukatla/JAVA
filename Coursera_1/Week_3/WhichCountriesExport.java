/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String currentCountry = record.get("Country");

            if (currentCountry.equalsIgnoreCase(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");

                String result = currentCountry + ": " + exports + ": " + value;
                return result;
            }
        }

        return "NOT FOUND";
    }


    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");

            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int totalCountry = 0;

        for (CSVRecord record : parser) {
            String exports = record.get("Exports");

            if (exports.contains(exportItem)) {
                totalCountry++;
            }
        }

        return totalCountry;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String currentAmount = record.get("Value (dollars)");

            if (currentAmount.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + currentAmount);
            }
        }
    }
    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        org.apache.commons.csv.CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
    public void tester(){
        FileResource fr = new FileResource();

        org.apache.commons.csv.CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "germany"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "gold"));

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }
}

class Main {
    public static void main(String args[]){
         WhichCountriesExport object = new WhichCountriesExport();
         object.tester();
    }
}

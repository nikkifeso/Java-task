import java.io.*;
import java.util.Arrays;
import java.util.List;

public class PhoneNumberSummarizer {
    public static void main(String[] args) {
        // Initialize variables
        List<String> mtn = Arrays.asList("0703", "0706", "0803", "0806", "0810", "0813", "0814", "0816", "0903", "0906",
                "0913", "0916", "07025", "07026", "0704");
        List<String> airtel = Arrays.asList("0701", "0708", "0802", "0808", "0812", "0901", "0902", "0904",
                "0907", "0912");
        List<String> globacom = Arrays.asList("0705", "0805", "0807", "0811", "0815", "0905", "0915");
        List<String> nineMobile = Arrays.asList("0809", "0817", "0818", "0909", "0908");
        List<String> mtel = List.of("0804");

        int countMtn = 0;
        int countAirtel = 0;
        int countGlobacom = 0;
        int countMtel = 0;
        int count9mobile = 0;

        // Read phone numbers and update count
        try (BufferedReader input = new BufferedReader(
                new FileReader("src/main/resources/PhoneNumbers.txt"))) {
            String item;
            while ((item = input.readLine()) != null) {
                String lengthFour = item.substring(0, 4);
                String lengthFive = item.substring(0, 5);
                if (mtn.contains(lengthFour)) {
                    countMtn ++;
                } else if (mtn.contains(lengthFive)) {
                    countMtn ++;
                } else if (mtel.contains(lengthFour)) {
                    countMtel ++;
                } else if (globacom.contains(lengthFour)) {
                    countGlobacom ++;
                } else if (airtel.contains(lengthFour)) {
                    countAirtel ++;
                } else if (nineMobile.contains(lengthFour)) {
                    count9mobile ++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write report to a File and System.out
        String report = "Summary report of the total number of phone numbers for each service provider" +
                "\nMtn: " + countMtn +
                "\nMtel: " + countMtel +
                "\nGlobacom: " + countGlobacom +
                "\nAirtel: " + countAirtel +
                "\n9Mobile: " + count9mobile;
        try (BufferedWriter file = new BufferedWriter(
                new FileWriter("src/main/resources/report.txt"))) {
            file.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(report);
    }
}

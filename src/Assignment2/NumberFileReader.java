// Camila Ramirez cramirezmendoza1@toromail.csudh.edu
package Assignment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class NumberFileReader {

    private String filename;

    // Constructor that takes the filename as an argument
    public NumberFileReader(String filename) {
        this.filename = filename;
    }

    // Method to read the file and return an array of integers
    public int[] readFileToArray() throws FileNotFoundException {
        Scanner reader = new Scanner(new File(this.filename));
        ArrayList<Integer> numberList = new ArrayList<>();


        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] numberArrays = line.split("\\s+");
            for (String numberArray : numberArrays) {
                try {
                    numberList.add(Integer.parseInt(numberArray));
                } catch (NumberFormatException e) {
                    // when string isnt a number
                    System.out.println("Invalid number format: " + numberArray);
                }
            }
        }
        reader.close();

        // Convert ArrayList to array
        int[] numbers = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbers[i] = numberList.get(i);
        }

        return numbers;
    }


    public static void main(String[] args) {
        try {
            NumberFileReader fr = new NumberFileReader("./numberFile.txt");
            int[] numbers = fr.readFileToArray();
            // Output the numbers to verify
            for (int number : numbers) {
                System.out.println(number);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");

        }
    }
}

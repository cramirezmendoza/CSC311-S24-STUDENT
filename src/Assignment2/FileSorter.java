// Camila Ramirez cramirezmendoza1@toromail.csudh.edu
package Assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileSorter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input filename from the user
        System.out.print("Enter the name of a file: ");
        String inFile = scanner.nextLine();

        // Get the output filename from the user
        System.out.print("Enter the name of the output file: ");
        String outFile = scanner.nextLine();

        try {
            // Read the numbers from the file
            NumberFileReader reader = new NumberFileReader(inFile);
            int[] numbers = reader.readFileToArray();

            // Sort the numbers
            BubbleSort sort = new BubbleSort(numbers);
            sort.sortAsc(numbers);


            // Write the sorted numbers to the output file
            NumberFileWriter fw = new NumberFileWriter(outFile);
            fw.write(numbers);

            System.out.println("Your new array file: " + outFile);
        } catch (FileNotFoundException e) {
            System.err.println("The file " + inFile + " wasn't made.");
        } catch (IOException e) {
            System.err.println("Error writing to " + outFile);
        } finally {
            scanner.close();
        }
    }
}


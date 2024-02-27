// Camila Ramirez cramirezmendoza1@toromail.csudh.edu
package Assignment2;

import java.io.FileWriter;
import java.io.IOException;

public class NumberFileWriter {

    private String filename;

    // Constructor that takes the filename as an argument
    public NumberFileWriter(String filename) {
        this.filename = filename;
    }


    public void write(int[] arrayOfNumbers) throws IOException {
        FileWriter fw = new FileWriter(this.filename);
        for (int number : arrayOfNumbers) {
            fw.write(number + "\n"); // Writing each number in the array to a new line
        }
        fw.close();
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            NumberFileWriter fw = new NumberFileWriter("./numberFileOut.txt");
            int[] newArray = {10, 6, 1, 4, 8, 3};
            fw.write(newArray);
            System.out.println("Written to new file");
        } catch (IOException e) {
            System.out.println("Error while writing to file");
        }
    }
}


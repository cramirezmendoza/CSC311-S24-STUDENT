package Assignment3;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataSetGenerator {

    public static void main(String[] args) {
        int startSize = 1000; // Starting with 1000 elements
        int increment = 1000; // Increment by 1000 for each file
        int numberOfFiles = 50; // Total number of files

        for (int i = 1; i <= numberOfFiles; i++) {
            int currentSize = startSize + (i - 1) * increment;
            String fileName = "DataSet_" + currentSize + ".txt";
            generateFile(fileName, currentSize);
        }
    }

    private static void generateFile(String fileName, int size) {
        try {
            FileWriter writer = new FileWriter(fileName);
            Random random = new Random();
            Set<Integer> set = new HashSet<>();

            while (set.size() < size) {
                // Ensure the range is large enough to accommodate the size
                // without too much risk of duplicates. Adjust as necessary.
                int number = random.nextInt(Integer.MAX_VALUE);
                set.add(number);
            }

            // Write each number in the set to the file
            for (int number : set) {
                writer.write(number + "\n");
            }

            writer.close();
            System.out.println("Successfully created " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while creating " + fileName);
            e.printStackTrace();
        }
    }
}

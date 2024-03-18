package Assignment3;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/camilaramirez/CSC311-S24-STUDENT/DataSet_50000.txt"; // Update this path

        try {
            int[] dataSet = DataReader.readDataSet(filePath);
            // make copies to not mess up the original data sets
            int[] bubbleSortDataSet = Arrays.copyOf(dataSet, dataSet.length);
            int[] insertionSortDataSet = Arrays.copyOf(dataSet, dataSet.length);
            int[] mergeSortDataSet = Arrays.copyOf(dataSet,dataSet.length);
            int[] quickSortDataSet = Arrays.copyOf(dataSet, dataSet.length);
            int[] radixSortDataSet = Arrays.copyOf(dataSet, dataSet.length);

            // Perform BubbleSort
            long startTimeBubbleSort = System.nanoTime();
            long iterationsBubbleSort = BubbleSort.bubbleSort(bubbleSortDataSet);
            long endTimeBubbleSort = System.nanoTime();
            long runtimeBubbleSort = (endTimeBubbleSort - startTimeBubbleSort) / 1000000;

            // Perform InsertionSort
            long startTimeInsertionSort = System.nanoTime();
            long iterationsInsertionSort = InsertionSort.insertionSort(insertionSortDataSet);
            long endTimeInsertionSort = System.nanoTime();
            long runtimeInsertionSort = (endTimeInsertionSort - startTimeInsertionSort) / 1000000;

            // Perform MergeSort
            long startTimeMergeSort = System.nanoTime();
            long iterationsMergeSort = MergeSort.mergeSort(mergeSortDataSet);
            long endTimeMergeSort = System.nanoTime();
            long runtimeMergeSort = (endTimeMergeSort - startTimeMergeSort) / 1000000;

            // Perform QuickSort
            long startTimeQuickSort = System.nanoTime();
            long iterationsQuickSort = QuickSort.quickSort(quickSortDataSet);
            long endTimeQuickSort = System.nanoTime();
            long runtimeQuickSort = (endTimeQuickSort - startTimeQuickSort) / 1000000;

            // Perform RadixSort
            long startTimeRadixSort = System.nanoTime();
            long iterationsRadixSort = RadixSort.radixSort(radixSortDataSet, radixSortDataSet.length);
            long endTimeRadixSort = System.nanoTime();
            long runtimeRadixSort = (endTimeRadixSort - startTimeRadixSort) / 1000000;


            // Print results
            System.out.println("BubbleSort completed in " + iterationsBubbleSort + " loops and took " + runtimeBubbleSort + " milliseconds.");
            System.out.println("InsertionSort completed in " + iterationsInsertionSort + " loops and took " + runtimeInsertionSort + " milliseconds.");
            System.out.println("MergeSort completed in " + iterationsMergeSort + " loops and took " + runtimeMergeSort + " milliseconds.");
            System.out.println("QuickSort completed in " + iterationsQuickSort + " loops and took " + runtimeQuickSort + " milliseconds.");
            System.out.println("RadixSort completed in " + iterationsRadixSort + " loops and took " + runtimeRadixSort + " milliseconds.");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred during file reading");
            e.printStackTrace();
        }
    }
}

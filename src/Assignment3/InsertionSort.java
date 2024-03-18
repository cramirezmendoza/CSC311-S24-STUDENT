package Assignment3;

public class InsertionSort {

    public static long insertionSort(int[] arr) {
        int n = arr.length;
        long iterations = 0; //iteration counter

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                iterations++; // Increment iterations
            }
            arr[j + 1] = key;

            iterations++;
        }

        return iterations; // Return the total number of iterations
    }
}

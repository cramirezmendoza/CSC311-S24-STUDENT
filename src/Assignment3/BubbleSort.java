package Assignment3;

public class BubbleSort {
    public static long bubbleSort(int[] arr) {
        int n = arr.length;
        long iterations = 0; // To count iterations

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                iterations++;
                if (arr[j] > arr[j+1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return iterations; // Return the total iterations
    }
}

package Assignment3;

public class QuickSort {

    private static int iterations; // This holds the number of iterations

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            iterations++; // Increment for the comparison
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                iterations++; // Increment for the swap
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        iterations++; // Increment for the swap
        return i + 1;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static long quickSort(int[] arr) {
        iterations = 0; // Reset the iteration count
        quickSort(arr, 0, arr.length - 1);
        return iterations;
    }
}

package Assignment3;

public class RadixSort {


    private static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }


    private static long countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        long iterations = 0;

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
            iterations++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            iterations++;
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            iterations++;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current num
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
            iterations++;
        }

        return iterations;
    }

    public static long radixSort(int[] arr, int length) {
        int n = arr.length;

        int m = getMax(arr, n);
        long totalIterations = 0;


        for (int exp = 1; m / exp > 0; exp *= 10) {
            totalIterations += countSort(arr, n, exp);
        }

        return totalIterations;
    }
}


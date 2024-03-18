package Assignment3;

public class MergeSort {

    private static long mergeSortInternal(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long iterations = 0;
        if (leftStart >= rightEnd) {
            return iterations;
        }
        int middle = (leftStart + rightEnd) / 2;
        iterations += mergeSortInternal(arr, temp, leftStart, middle);
        iterations += mergeSortInternal(arr, temp, middle + 1, rightEnd);
        iterations += merge(arr, temp, leftStart, rightEnd);
        return iterations;
    }

    private static long merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long iterations = 0;
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            iterations++;
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

        return iterations;
    }

    public static long mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortInternal(arr, temp, 0, arr.length - 1);
    }
}

// Camila Ramirez cramirezmendoza1@toromail.csudh.edu
package Assignment2;

public class BubbleSort {
    private int[] sortArray;
    private int loopCycles;

    public BubbleSort(int[] array){
        this.sortArray = array;
    }
    public int[] sortAsc(int[] array){
        int i, j, temp;
        boolean swap;
        loopCycles = 0;

        for(i = 0; i < array.length - 1; i++){
            swap = false;

            for (j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;

                }
            }
            loopCycles++;

            if (!swap){
                break;
            }
        }
        return array;
    }
    public int[] sortDesc(int[] array){
        int i, j, temp;
        boolean swap;
        loopCycles = 0;

        for (i = 0; i < array.length - 1; i++) {
            swap = false;

            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            loopCycles++;

            if(!swap) {
                break;
            }
        }
        return array;
    }
    public int loopCycles(){
        return loopCycles;
    }
    public static void main(String[] args) {
        int[] testArray = {10, 6, 1, 4, 8, 3};

        BubbleSort bSort = new BubbleSort(testArray);


        int[] newArray = bSort.sortAsc(testArray);
        System.out.println("Ascending order: ");
        for (int num : newArray) { // Use newArray instead of sortArc
            System.out.print(num + " ");
        }

        System.out.println("\nAscending sort loop cycles: " + bSort.loopCycles());

        int[] newArray2 = bSort.sortDesc(testArray);
        System.out.println("Descending order: ");
        for (int num : newArray) { //
            System.out.print(num + " ");
        }
        System.out.println("\nDescending sort loop cycles: " + bSort.loopCycles());
    }
}

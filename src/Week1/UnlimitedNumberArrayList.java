package Week1;

// Camila Ramirez cramirezmendoza1@toromail.csudh.edu
public class UnlimitedNumberArrayList {
    private int[] num;
    private int count;
    public UnlimitedNumberArrayList() {
        num = new int[1];
        count = 0;
    }
    public int add(int number) {
        if (count == num.length) {
            int[] newNum = new int[num.length * 2];
            System.arraycopy(num, 0, newNum, 0, num.length);
            num = newNum;
        }
        num[count] = number;
        return count++;
    }
    public int get(int location){
        if (location >= 0 && location < count){
            return num[location];
        } else {
            return -1;
        }
    }
    public int size(){
        return count;
    }
    public int[] find(int number){
        int[] temp = new int[count];
        int newCount = 0;
        for(int i = 0; i < count; i++){
            if (num[i] == number){
                temp[newCount++] = i;
            }
        }
        int[] index = new int[newCount];
        System.arraycopy(temp, 0, index, 0,  newCount);
        return index;
    }
    public int findLargest() {
        if(count == 0) return -1;
        int max = num[0]; // Assume first element is the largest initially
        for (int i = 1; i < count; i++) {
            if (num[i] > max) {
                max = num[i]; // Update max if current element is larger
            }
        }
        return max;
    }
    public int findSmallest(){
        if (count == 0) return - 1;
        int min = num[0]; // Assume first element is the smallest initially
        for (int i = 1; i < count; i++) {
            if (num[i] < min) {
                min = num[i]; // Update min if current element is smaller
            }
        }
        return min;
    }
    public int Average(){
        if (count == 0) return -1;
        int sum = 0;
        for (int i = 0; i < count; i++){
            sum += num[i];
        }
        return sum / count;
    }

    @Override
    public String toString() {
        if (count == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append(num[0]);
        for (int i = 1; i < count; i++) {
            sb.append(", ").append(num[i]);
        }
        return sb.toString();
    }
}

import java.util.Arrays;

class DeterministicSelectEasy {

    
    public static int select(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k];     
    }

    public static void main(String[] args) {
        int[] numbers = {9, 2, 7, 4, 1, 6, 5, 3, 8};
        int k = 4; 
        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("k-th smallest element = " + select(numbers, k));
    }
}

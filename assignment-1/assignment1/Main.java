import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example input array
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array: " + Arrays.toString(arr));

        // ===== MergeSort =====
        int[] arr1 = arr.clone();
        MergeSortSimple.sort(arr1);
        System.out.println("MergeSort: " + Arrays.toString(arr1));

        // ===== QuickSort =====
        int[] arr2 = arr.clone();
        QuickSortEasy.sort(arr2);
        System.out.println("QuickSort: " + Arrays.toString(arr2));

        // ===== Deterministic Select =====
        int[] arr3 = arr.clone();
        int k = 3; // 0-based index → 4th smallest
        int kth = DeterministicSelectSimple.select(arr3, k);
        System.out.println("Deterministic Select (k=" + k + "): " + kth);

        // ===== Closest Pair of Points =====
        ClosestPairEasy.Point[] pts = {
            new ClosestPairEasy.Point(2, 3),
            new ClosestPairEasy.Point(12, 30),
            new ClosestPairEasy.Point(40, 50),
            new ClosestPairEasy.Point(5, 1),
            new ClosestPairEasy.Point(12, 10),
            new ClosestPairEasy.Point(3, 4)
        };
        double dist = ClosestPairEasy.closest(pts);
        System.out.println("Closest Pair distance = " + dist);
    }
}



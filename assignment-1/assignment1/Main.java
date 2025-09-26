import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 10000; // size of test array
        Random rand = new Random();

        // Prepare a random array
        int[] arr = rand.ints(n, 0, 100000).toArray();

        // ==== Test MergeSort ====
        int[] arr1 = arr.clone();
        long start = System.nanoTime();
        MergeSort.sort(arr1);
        long end = System.nanoTime();
        System.out.println("MergeSort time: " + (end - start)/1e6 + " ms");

        // ==== Test QuickSort ====
        int[] arr2 = arr.clone();
        start = System.nanoTime();
        QuickSort.sort(arr2);
        end = System.nanoTime();
        System.out.println("QuickSort time: " + (end - start)/1e6 + " ms");

        // ==== Test Deterministic Select (median element) ====
        int[] arr3 = arr.clone();
        start = System.nanoTime();
        int kth = DeterministicSelect.select(arr3, arr3.length/2);
        end = System.nanoTime();
        System.out.println("Deterministic Select (median): " + kth +
                           ", time: " + (end - start)/1e6 + " ms");

        // ==== Test Closest Pair ====
        ClosestPair.Point[] pts = new ClosestPair.Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new ClosestPair.Point(rand.nextDouble()*1000, rand.nextDouble()*1000);
        }
        start = System.nanoTime();
        double d = ClosestPair.closest(pts);
        end = System.nanoTime();
        System.out.println("Closest Pair distance: " + d +
                           ", time: " + (end - start)/1e6 + " ms");
    }
}

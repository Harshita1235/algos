import java.util.Random;

class QuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int lo, int hi) {
        while (lo < hi) {
            int p = partition(arr, lo, hi);
            // Recurse on smaller side only
            if (p - lo < hi - p) {
                quicksort(arr, lo, p - 1);
                lo = p + 1;
            } else {
                quicksort(arr, p + 1, hi);
                hi = p - 1;
            }
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivotIndex = lo + rand.nextInt(hi - lo + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, hi);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) swap(arr, i++, j);
        }
        swap(arr, i, hi);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}

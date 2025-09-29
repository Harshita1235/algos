import java.util.Arrays;

class Select {
    public static int select(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int lo, int hi, int k) {
        if (lo == hi) return arr[lo];
        int pivot = medianOfMedians(arr, lo, hi);
        int p = partition(arr, lo, hi, pivot);
        if (k == p) return arr[p];
        else if (k < p) return select(arr, lo, p - 1, k);
        else return select(arr, p + 1, hi, k);
    }

    private static int partition(int[] arr, int lo, int hi, int pivot) {
        int i = lo, j = hi;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) { swap(arr, i, j); i++; j--; }
        }
        return i - 1;
    }

    private static int medianOfMedians(int[] arr, int lo, int hi) {
        int n = hi - lo + 1;
        if (n <= 5) {
            Arrays.sort(arr, lo, hi + 1);
            return arr[lo + n/2];
        }
        int numMedians = 0;
        for (int i = lo; i <= hi; i += 5) {
            int subHi = Math.min(i + 4, hi);
            Arrays.sort(arr, i, subHi + 1);
            int median = arr[i + (subHi - i)/2];
            arr[lo + numMedians] = median;
            numMedians++;
        }
        return medianOfMedians(arr, lo, lo + numMedians - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}


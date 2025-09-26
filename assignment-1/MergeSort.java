class MergeSort {
    private static final int CUTOFF = 16; // insertion sort threshold

    public static void sort(int[] arr) {
        int[] buffer = new int[arr.length];
        sort(arr, buffer, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] buf, int lo, int hi) {
        if (hi - lo <= CUTOFF) {
            insertionSort(arr, lo, hi);
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, buf, lo, mid);
        sort(arr, buf, mid + 1, hi);
        merge(arr, buf, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] buf, int lo, int mid, int hi) {
        System.arraycopy(arr, lo, buf, lo, hi - lo + 1);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = buf[j++];
            else if (j > hi) arr[k] = buf[i++];
            else if (buf[j] < buf[i]) arr[k] = buf[j++];
            else arr[k] = buf[i++];
        }
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i], j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

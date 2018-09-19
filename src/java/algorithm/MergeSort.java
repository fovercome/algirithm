package java.algorithm;

public class MergeSort {
    private int[] tmp;
    private void merge(int[] arr, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; ++k) {
            tmp[k] = arr[k];
        }
        for (int k = l; k <= h; ++k) {
            if (i > m) {
                arr[k] = tmp[j++];
            } else if (j > h) {
                arr[k] = tmp[i++];
            } else if (arr[i] < arr[j]) {
                arr[k] = tmp[i++];
            }
            else{
                arr[k] = tmp[j++];
            }
        }
    }

    private void sort(int[] arr, int l, int h) {
        if(l >= h) return;
        int mid = l + (h - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, h);
        merge(arr, l, mid, h);
    }

    public void sort(int[] arr) {
        int n = arr.length;
        tmp = new int[n];
        sort(arr, 0, n-1);
    }
}

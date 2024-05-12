package string_sorts.task_5_1_14;

import java.util.List;

public class Sort {
    Sort() {

    }
    private static int min = -2147483647;
    public static void quickTwoDimensionalArraySort(List<List<Integer>> arr) {
        sort(arr, 0, arr.size() - 1, 0);
    }
    private static int numberAt(List<Integer> arr, int ptr) {
        if (ptr < arr.size()) return arr.get(ptr);
        else return min;
    }
    private static void sort(List<List<Integer>> arr, int left, int right, int d) {
        if (right <= left) return;
        int ptr1 = left;
        int ptr2 = right;
        int v = numberAt(arr.get(left), d);
        int i = left + 1;
        while (i <= ptr2) {
            int t = numberAt(arr.get(i), d);
            if (t < v) {
                swap(arr, ptr1++, i++);
            } else if (t > v) {
                swap(arr, i, ptr2--);
            } else {
                i++;
            }
        }
        sort(arr, left, ptr1 - 1, d);
        if (v >= 0) sort(arr, ptr1, ptr2, d + 1);
        sort(arr, ptr2 + 1, right, d);
    }
    private static void swap(List<List<Integer>> a, int ptr1, int ptr2) {
        List<Integer> temp = a.get(ptr1);
        a.set(ptr1, a.get(ptr2));
        a.set(ptr2, temp);
    }
}

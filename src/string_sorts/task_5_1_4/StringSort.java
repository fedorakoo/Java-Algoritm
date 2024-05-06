package string_sorts.task_5_1_4;

public class StringSort {
    StringSort() {

    }
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }
    public static void quickStringSort(String[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }
    private static void sort(String[] arr, int left, int right, int d) {
        if (right <= left) return;
        int ptr1 = left;
        int ptr2 = right;
        int v = charAt(arr[left], d);
        int i = left + 1;
        while (i <= ptr2) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            int t = charAt(arr[i], d);
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
    private static void swap(String[] arr, int ptr1, int ptr2) {
        String temp = arr[ptr1];
        arr[ptr1] =  arr[ptr2];
        arr[ptr2] =  temp;
    }
}

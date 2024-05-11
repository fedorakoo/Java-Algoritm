package string_sorts.task_5_1_4;

import java.util.List;

public class StringSort {
    StringSort() {

    }
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }
    public static void quickStringSort(List<String> arr) {
        sort(arr, 0, arr.size() - 1, 0);
    }
    private static void sort(List<String> arr, int left, int right, int d) {
        if (right <= left) return;
        int ptr1 = left;
        int ptr2 = right;
        int v = charAt(arr.get(left), d);
        int i = left + 1;
        while (i <= ptr2) {
            for(int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
            String value;
            if (i < arr.size()) {
                value = arr.get(i);
            } else {
                return;
            }
            int t = charAt(value, d);
            if (t < v) {
                String temp = arr.get(ptr1);
                arr.set(ptr1, arr.get(i));
                arr.set(i, temp);
                ptr1++;
                i++;
            } else if (t > v) {
                String temp = arr.get(ptr2);
                arr.set(ptr2, arr.get(i));
                arr.set(i, temp);
                ptr2--;
            } else {
                i++;
            }
        }
        sort(arr, left, ptr1 - 1, d);
        if (v >= 0) sort(arr, ptr1, ptr2, d + 1);
        sort(arr, ptr2 + 1, right, d);
    }
}

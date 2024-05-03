package string_sorts.task_5_1_4;

import java.util.List;

public class StringSort {
    StringSort() {

    }
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }
    public static void quickStringSort(List<String> a) {
        sort(a, 0, a.size() - 1, 0);
    }
    private static void sort(List<String> a, int left, int right, int d) {
        if (right <= left) return;
        int ptr1 = left;
        int ptr2 = right;
        int v = charAt(a.get(left), d);
        int i = left + 1;
        while (i <= ptr2) {
            int t = charAt(a.get(i), d);
            if (t < v) {
                swap(a, ptr1++, i++);
            } else if (t > v) {
                swap(a, i, ptr2--);
            } else {
                i++;
            }
        }
        sort(a, left, ptr1 - 1, d);
        if (v >= 0) sort(a, ptr1, ptr2, d + 1);
        sort(a, ptr2 + 1, right, d);
    }
    private static void swap(List<String> a, int ptr1, int ptr2) {
        String temp = a.get(ptr1);
        a.set(ptr1, a.get(ptr2));
        a.set(ptr2, temp);
    }
}

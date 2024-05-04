package string_sorts.task_5_1_19;

import java.util.List;

public class Sort {
    private Sort() {

    }
    private static final  int R = 256;
    private static final int L = 15;
    private static String[] helpArr;                // Вспомогательный массив для распределения

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(List<String> a) {
        int n = a.size();
        helpArr = new String[n];
        sort(a, 0, n - 1, 0);
    }

    private static void sort(List<String> arr, int left, int right, int d) {
        if (right <= left + L) {
            insertionSort(arr, left, right, d);
            return;
        }
        int[] count = new int[R + 2];
        for (int i = left; i <= right; i++)
            count[charAt(arr.get(i), d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = left; i <= right; i++)
            helpArr[count[charAt(arr.get(i), d) + 1]++] = arr.get(i);
        for (int i = left; i <= right; i++)
            arr.set(i, helpArr[i - left]);

        for (int i = 0; i < R; i++) {
            sort(arr, left + count[i], left + count[i + 1] - 1, d + 1);
        }
    }

    public static void insertionSort(List<String> arr, int left, int right, int d) {
        for (int i = left + 1; i <= right; i++) {
            String temp = arr.get(i);
            int j = i - 1;
            while (j >= left && arr.get(j).substring(d).compareTo(temp.substring(d)) > 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);
        }
    }
}

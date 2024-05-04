package string_sorts.task_5_1_20;

import java.util.List;

public class Sort {
    private Sort() {

    }
    public static void sort(List<String> arr, int size) {
        int n = arr.size();
        int r = 256;
        String[] aux = new String[n];
        for (int d = size - 1; d >= 0; d--) {
            int[] count = new int[r + 1];
            for (int i = 0; i < n; i++)
                count[arr.get(i).charAt(d) + 1]++;

            for (int j = 0; j < r; j++)
                count[j + 1] += count[j];

            for (int i = 0; i < n; i++)
                aux[count[arr.get(i).charAt(d)]++] = arr.get(i);

            for (int i = 0; i < n; i++)
                arr.set(i,aux[i]);
        }
    }
}

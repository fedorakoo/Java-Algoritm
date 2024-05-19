package substring_search.task_5_3_6;
public class BoyerMoore {
    private int[] right;

    BoyerMoore(String pat) {
        int m = pat.length();
        int r = 256;
        right = new int[r];

        for (int c = 0; c < r; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < m; j++) {
            right[pat.charAt(j)] = j;
        }

        System.out.print("Содержимое массива right: ");
        for(int i = 0; i < right.length; i++) {
            if(right[i] != -1) {
                System.out.print((char) 27 + "[31m" + Integer.toString(right[i]) + (char)27 + "[0m" + " ");
            }
            else {
                System.out.print(right[i] + " ");
            }
        }
    }
}

package substring_search.task_5_3_37;

public class KMP {
    private KMP() {

    }
    static int searchKMP(String substr, String text) {
        int number = 0;
        int m = substr.length();
        int n = text.length();
        int[] arr = new int[m];
        int j = 0;
        number += computeLPSArray(substr, m, arr);
        int i = 0;
        while (i < n) {
            if (substr.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            number += 2;
            if (j == m) {
                j = arr[j - 1];
            }
            else if (i < n && substr.charAt(j) != text.charAt(i)) {
                number += 2;
                if (j != 0) {
                    j = arr[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
        return number;
    }
    static int computeLPSArray(String substr, int m, int[] arr) {
        int number = 0;
        int len = 0;
        int i = 1;
        arr[0] = 0;
        while (i < m) {
            number++;
            if (substr.charAt(i) == substr.charAt(len)) {
                len++;
                arr[i] = len;
                i++;
            }
            else {
                number++;
                if (len != 0) {
                    len = arr[len - 1];
                }
                else {
                    arr[i] = len;
                    i++;
                }
            }
        }
        return number;
    }
}
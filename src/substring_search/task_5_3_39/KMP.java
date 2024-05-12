package substring_search.task_5_3_39;

public class KMP {
    private KMP() {

    }
    static void search(String substr, String txt) {
        int m = substr.length();
        int n = txt.length();
        int[] arr = new int[m];
        int j = 0;
        computeLPSArray(substr, m, arr);
        int i = 0;
        while (i < n) {
            if (substr.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                j = arr[j - 1];
            }
            else if (i < n && substr.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = arr[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
    }
    static int computeLPSArray(String substr, int m, int[] arr) {
        int number = 0;
        int len = 0;
        int i = 1;
        arr[0] = 0;
        while (i < m) {
            if (substr.charAt(i) == substr.charAt(len)) {
                len++;
                arr[i] = len;
                i++;
            } else
            {
                if (len != 0) {
                    len = arr[len - 1];
                }
                else {
                    arr[i] = len;
                    i++;
                }
            }
            number++;
        }
        return number;
    }
}

package substring_search.task_5_3_39;

public class BoyerMoore {
    private BoyerMoore() {

    }
    public static void search(String substr, String text) {
        int patternSize = substr.length();
        int textSize = text.length();

        int i = 0;
        int j = 0;

        while ((i + patternSize) <= textSize) {
            j = patternSize - 1;
            while (text.charAt(i + j) == substr.charAt(j)) {
                j--;
                if (j < 0) {
                    return;
                }            }
            i++;
        }
    }
}

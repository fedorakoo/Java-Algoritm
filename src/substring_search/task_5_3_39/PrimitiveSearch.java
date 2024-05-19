package substring_search.task_5_3_39;

public class PrimitiveSearch {
    private PrimitiveSearch() {

    }
    public static void search(String substr, String text) {
        int patternSize = substr.length();
        int textSize = text.length();
        int i = 0;

        while ((i + patternSize) <= textSize) {
            int j = 0;

            while (text.charAt(i + j) == substr.charAt(j)) {
                j += 1;
            }
            i += 1;
        }
    }
}

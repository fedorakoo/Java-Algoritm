package substring_search.task_5_3_26;

public class CyclicPermutations {
    private CyclicPermutations(){

    }
    public static boolean isPermutation(String first, String second) {
        if(first.length() != second.length()) {
            return false;
        }
        int[] firstArr = new int[33];
        int[] secondArr = new int[33];
        for(int i = 0; i < first.length(); i++) {
            firstArr[first.charAt(i) % 33]++;
        }
        for(int i = 0; i < second.length(); i++) {
            secondArr[second.charAt(i) % 33]++;
        }
        for(int i = 0; i < 33; i++) {
            if (firstArr[i] != secondArr[i]) {
                return false;
            }
        }
        return true;
    }
}

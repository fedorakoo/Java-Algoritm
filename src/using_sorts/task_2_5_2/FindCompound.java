package using_sorts.task_2_5_2;

import java.util.List;

public class FindCompound {
    private FindCompound() {

    }

    public static String findCompound(List<String> wordsSorted) {
        int[] letters = new int[33];
        char startLetter = getStartLetter(wordsSorted.get(0).charAt(0));
        int sizeAlphabet = getSizeAlphabet(wordsSorted.get(0).charAt(0));
        for (int i = 0; i < wordsSorted.size(); i++) {
            if (letters[wordsSorted.get(i).charAt(0) - startLetter] == 0) {
                letters[wordsSorted.get(i).charAt(0) - startLetter] = i + 1;
            }
        }
        letters = getCorrectArray(wordsSorted.size(), letters);
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < wordsSorted.size(); i++) {
            for (int j = Math.max(i, letters[wordsSorted.get(i).charAt(0) - startLetter]); wordsSorted.get(i).charAt(0) - startLetter + 1 < sizeAlphabet && j < letters[wordsSorted.get(i).charAt(0) - startLetter + 1]; j++) {
                String firstWord = wordsSorted.get(i);
                String secondWord = wordsSorted.get(j);
                if (isFirstWordBeginningSecond(firstWord, secondWord)) {
                    String finalPartWord = secondWord.substring(firstWord.length(), secondWord.length());
                    if (binarySearch(wordsSorted, finalPartWord, 0, wordsSorted.size() - 1) != -1) {
                        bld.append(secondWord + "\n");
                    }
                }
            }

        }
        return bld.toString();
    }
    private static int getSizeAlphabet(char firstLetter) {
        return (isLetterEnglish(firstLetter) ? 29 : 33);
    }
    private static char getStartLetter(char firstLetter) {
        return (isLetterEnglish(firstLetter) ? 'a' : 'а');
    }
    private static boolean isLetterEnglish(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }
    private static boolean isFirstWordBeginningSecond(String firstWord, String secondWord) {
        if (firstWord.length() >= secondWord.length()) {
            return false;
        } else {
            for (int i = 0; i < firstWord.length(); i++) {
                if (firstWord.charAt(i) != secondWord.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static int binarySearch(List<String> wordsSorted, String word, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        } else if (word.equals(wordsSorted.get(mid))) {
            return mid;
        } else if (!isFirstWordMoreSecond(word, wordsSorted.get(mid))) {
            return binarySearch(wordsSorted, word, low, mid - 1);
        } else {
            return binarySearch(wordsSorted, word, mid + 1, high);
        }
    }

    private static boolean isFirstWordMoreSecond(String firstWord, String secondWord) {
        int minLength = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < minLength; i++) {
            if (firstWord.charAt(i) > secondWord.charAt(i)) {
                return true;
            } else if (firstWord.charAt(i) < secondWord.charAt(i)) {
                return false;
            }
        }
        return (firstWord.length() > secondWord.length());
    }

    private static int[] getCorrectArray(int sizeArrayList, int[] letters) {
        int maxPtr = sizeArrayList;
        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] == 1) {
                letters[i] = 0;
                break;
            } else if (letters[i] != 0) {
                maxPtr = letters[i] - 1;
            } else letters[i] = maxPtr;
        }
        return letters;
    }
}

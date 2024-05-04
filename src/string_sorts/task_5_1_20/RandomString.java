package string_sorts.task_5_1_20;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomString {
    private RandomString() {

    }
    public static List<String> getRandomArrayWords(int number, int size) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            result.add(getRandomWord(size));
        }
        return result;
    }
    public static String getRandomWord(int size) {
        StringBuilder bld = new StringBuilder();
        for(int i = 0; i < size; i++) {
            bld.append(getRandomLetter());
        }
        return bld.toString();
    }
    private static char getRandomLetter() {
        return (char)random.nextInt('A',  'Z' + 1);
    }
    static Random random = new SecureRandom();
}

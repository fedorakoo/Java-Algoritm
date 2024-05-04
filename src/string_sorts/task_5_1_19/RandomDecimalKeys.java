package string_sorts.task_5_1_19;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDecimalKeys {
    private RandomDecimalKeys() {

    }
    public static List<String> getRandomArrayCarNumber(int number) {
        List<String> result = new ArrayList<>();
        for(int j = 0; j < number; j++) {
            StringBuilder bld = new StringBuilder();
            bld.append(getRandomNumber());
            for (int i = 0; i < 3; i++) {
                bld.append(getRandomLetter());
            }
            for (int i = 0; i < 3; i++) {
                bld.append(getRandomNumber());
            }
            result.add(bld.toString());
        }
        return result;
    }
    private static char getRandomLetter() {
        return (char)random.nextInt('A',  'Z');
    }
    private static char getRandomNumber() {
        return (char)random.nextInt('0',  '9');
    }
    static Random random = new SecureRandom();
}

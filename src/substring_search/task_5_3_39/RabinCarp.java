package substring_search.task_5_3_39;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RabinCarp {
    private RabinCarp() {

    }
    public static void search(String substr, String text) {
        int prime = getBiggerPrime(substr.length());
        int r = 1;
        for (int i = 0; i < substr.length() - 1; i++) {
            r *= 2;
            r = r % prime;
        }
        int[] t = new int[text.length()];
        if(text.length() != 0) {
            t[0] = 0;
            int number = 0;
            for (int j = 0; j < substr.length(); j++) {
                t[0] = (2 * t[0] + text.charAt(j)) % prime;
                number = (2 * number + substr.charAt(j)) % prime;
            }
            int i = 0;
            int diff = text.length() - substr.length();
            for (i = 0; i <= diff; i++) {
                if (t[i] == number) {
                    for (int k = 0; k < substr.length(); k++) {
                        if (text.charAt(i + k) != substr.charAt(k)) {
                            break;
                        } else {
                            return;
                        }
                    }
                }
                if (i < diff) {
                    int value = 2 * (t[i] - r * text.charAt(i)) + text.charAt(i + substr.length());
                    t[i + 1] = ((value % prime) + prime) % prime;
                }
            }
        }
    }
    private static int getBiggerPrime(int m) {
        BigInteger prime = BigInteger.probablePrime(getNumberOfBits(m) + 1, new SecureRandom());
        return (int)prime.longValue();
    }
    private static int getNumberOfBits(int number) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(number);
    }
}

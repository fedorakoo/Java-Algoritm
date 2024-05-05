package hash_table.task_3_4_39;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnalysis {
    private RandomAnalysis() {

    }
    private static List<Integer> filling(int size) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            result.add(0);
        }
        Random random = new SecureRandom();
        for (int i = 0; i < size / 2; i++) {
            int key = random.nextInt(size);
            int j = key % size;
            while (result.get(j) != 0) {
                j = (j + 1) % size;
            }
            result.set(j, key);
        }
        return result;
    }

    public static double calculateMisses(int size) {
        List<Integer> arr = filling(size);
        int misses = 0;
        int operation = 0;
        for (int i = 0; i < size; i++) {
            if (arr.get(i) == 0) {
                int j = i;
                while (arr.get(j) == 0) {
                    j = (j + 1) % size;
                    misses++;
                }
                operation++;
            }
        }
        return (operation == 0 ? 0 : (double) misses / operation);
    }
}

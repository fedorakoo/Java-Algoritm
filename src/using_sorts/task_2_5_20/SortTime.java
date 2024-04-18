package using_sorts.task_2_5_20;

import javax.imageio.ImageTranscoder;
import java.util.*;

public class SortTime {
    private SortTime() {

    }

    public static String getTimeIntervals(List<String> arrListStart, List<String> arrListEnd) {
        List<Integer> minuteStartList = new LinkedList<>();
        List<Integer> minuteEndList = new LinkedList<>();
        for(int i = 0; i < arrListStart.size(); i++) {
            minuteStartList.add(countMinute(arrListStart.get(i)));
            minuteEndList.add(countMinute(arrListEnd.get(i)));
        }
        for (int i = 1; i < minuteStartList.size(); ++i) {
            int value1 = minuteStartList.get(i);
            int value2 = minuteEndList.get(i);
            int j = i - 1;
            while (j >= 0 && minuteStartList.get(j) > value1) {
                int temp1 = minuteStartList.get(j);
                minuteStartList.set(j + 1, minuteStartList.get(j));
                minuteStartList.set(j, temp1);

                int temp2 = minuteEndList.get(j);
                minuteEndList.set(j + 1, minuteEndList.get(j));
                minuteEndList.set(j, temp2);
                
                j--;
            }
            minuteStartList.set(j + 1, value1);
            minuteEndList.set(j + 1, value2);
        }
        
        int result = 0;
        for(int i = 0; i < minuteStartList.size() - 1; ++i) {
            int value = minuteStartList.get(i + 1) - minuteEndList.get(i);
            if(value > 0) {
                result = Math.max(result, value);
            }
        }
        return "Самый продолжительный интервал простоя процессора длился: " + Integer.toString(result) + " минут.";
    }
    private static String numberToString(int n) {
        if (n < 10) {
            return "0" + Integer.toString(n);
        }
        else {
            return Integer.toString(n);
        }
    }

    private static int countMinute(String line) {
        int hour = Integer.parseInt(line.substring(0, 2));
        int minute = Integer.parseInt(line.substring(3, 5));
        return hour * 60 + minute;
    }
}

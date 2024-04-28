package using_sorts.task_2_5_20;

import java.util.*;

public class SortTime {
    private SortTime() {

    }
    public static String getTimeIntervals(List<String> arrListStart, List<String> arrListEnd) {
        List<Integer> minuteStartList = new LinkedList<>();
        List<Integer> minuteEndList = new LinkedList<>();
        for (int i = 0; i < arrListStart.size(); i++) {
            minuteStartList.add(countSecond(arrListStart.get(i)));
            minuteEndList.add(countSecond(arrListEnd.get(i)));
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

        int firstResult = 0;
        for (int i = 0; i < minuteStartList.size() - 1; ++i) {
            int value = minuteStartList.get(i + 1) - minuteEndList.get(i);
            if (value > firstResult) {
                firstResult = value;
            }
        }
        
        int secondResult = 0;
        int value = 0;
        int startResult = 0;
        int finalResult = 0;
        for (int i = 0; i < minuteEndList.size(); i++) {
           if(value == 0) {
               startResult = minuteStartList.get(i);
               finalResult = minuteEndList.get(i);
           }
           else if(value != 0 && i + 1 < minuteEndList.size() && minuteEndList.get(i) >= minuteStartList.get(i + 1)) {
               finalResult = Math.max(minuteEndList.get(i), finalResult);
           }
           else {
               secondResult = Math.max(finalResult - startResult, secondResult);
           }
            secondResult = Math.max(finalResult - startResult, secondResult);
        }
        return "\nСамый продолжительный интервал простоя процессора длился: " + toString(firstResult) + "\n" +
                "Самый продолжительный интервал работы процессора длился: " + toString(secondResult) + "\n ";
    }

    public static int countSecond(String line) {
        int hour = Integer.parseInt(line.substring(0, 2));
        int minute = Integer.parseInt(line.substring(3, 5));
        int second = Integer.parseInt(line.substring(6, 8));
        return hour * 3600 + minute * 60 + second;
    }
    private static String toString(int second) {
        int hour = second / 3600;
        second %= 3600;
        int minute = second / 60;
        second %= 60;
        return getCorrectTime(hour) + ":" + getCorrectTime(minute) + ":" + getCorrectTime(second);
    }
    private static String getCorrectTime(int time) {
        String strTime = Integer.toString(time);
        return (strTime.length() == 1) ? "0" + strTime : strTime;
    }
}

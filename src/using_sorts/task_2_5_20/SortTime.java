package using_sorts.task_2_5_20;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortTime {
    private SortTime() {

    }

    public static String getTimeIntervals(List<String> arrList) {
        List<Integer> minuteList = new LinkedList<>();
        for (int i = 0; i < arrList.size(); i++) {
            minuteList.add(countMinute(arrList.get(i)));
        }
        Collections.sort(minuteList);
        int momentShortestNumber = 0;
        int shortestTimeInterval = minuteList.get(1) - minuteList.get(0);
        int momentLongestNumber = 0;
        int longestTimeInterval = minuteList.get(1) - minuteList.get(0);
        for (int i = 0; i < arrList.size(); i += 2) {
            if (minuteList.get(i + 1) - minuteList.get(i) < shortestTimeInterval) {
                momentShortestNumber = i;
                shortestTimeInterval = minuteList.get(i + 1) - minuteList.get(i);
            }
            if (minuteList.get(i + 1) - minuteList.get(i) > longestTimeInterval) {
                momentLongestNumber = i;
                longestTimeInterval = minuteList.get(i + 1) - minuteList.get(i);
            }
        }
        String finiteTimeIntervals = "Самый короткий интервал: c " + Integer.toString(minuteList.get(momentShortestNumber) / 60) + ":" + numberToString(minuteList.get(momentShortestNumber) % 60) + " по " + numberToString(minuteList.get(momentShortestNumber + 1) / 60) + ":" + numberToString(minuteList.get(momentShortestNumber + 1) % 60) + "\n" + "Самый длинный интервал: с " + numberToString(minuteList.get(momentLongestNumber) / 60) + ":" + numberToString(minuteList.get(momentLongestNumber) % 60) + " по " + numberToString(minuteList.get(momentLongestNumber + 1) / 60) + ":" + numberToString(minuteList.get(momentLongestNumber + 1) % 60) + "\n";
        return finiteTimeIntervals;
    }

    private static String numberToString(int n) {
        if (n < 10) {
            return "0" + Integer.toString(n);
        } else {
            return Integer.toString(n);
        }
    }

    private static int countMinute(String line) {
        int hour = Integer.parseInt(line.substring(0, 2));
        int minute = Integer.parseInt(line.substring(3, 5));
        return hour * 60 + minute;
    }
}

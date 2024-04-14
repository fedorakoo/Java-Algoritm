package using_sorts.task_2_5_13;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LPT {
    private LPT() {

    }

    public static String orderOfExecution(Map<Double, String> unsortedMap) {
        StringBuilder bld = new StringBuilder();
        Map<Double, String> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(unsortedMap);
        for (Map.Entry<Double, String> entry : sortedMap.entrySet()) {
            bld.append("Наименование задания: " + entry.getValue() + "\t|\tКоличество часов: " + entry.getKey() + "\n");
        }
        return bld.toString();
    }
}

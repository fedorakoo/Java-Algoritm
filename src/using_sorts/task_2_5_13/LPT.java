package using_sorts.task_2_5_13;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LPT {
    private LPT() {

    }

    public static String orderOfExecution(Map<String, Double> unsortedMap) {
        StringBuilder bld = new StringBuilder();
        
        List<Map.Entry<String, Double>> list = new ArrayList<>(unsortedMap.entrySet());
        list.sort(Map.Entry.<String, Double>comparingByValue().reversed());
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
            bld.append("Наименование задания: " + entry.getKey() + "\t|\tКоличество секунд: " + entry.getValue() + "\n");
        }
        return bld.toString();
    }
}

package string_sorts.task_5_1_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Провести трассировку работы трехчастной быстрой сортировки для строковых ключей.");
        List<String> lines = new ArrayList<>(Arrays.asList("no", "is", "th", "ti", "fo", "al", "go", "pe", "to", "co", "to", "th", "ai", "of", "th", "pa"));
        StringSort.quickStringSort(lines);
        System.out.println("\nРезультат работы сортировки");
        for(int i = 0; i < lines.size(); i++) {
            System.out.print(lines.get(i) + " ");
        }
        System.out.println();
    }
}

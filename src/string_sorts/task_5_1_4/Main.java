package string_sorts.task_5_1_4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Провести трассировку работы трехчастной быстрой сортировки для строковых ключей.");
        String[] lines = {"no", "is", "th", "ti", "fo", "al", "go", "pe", "to", "co", "to", "th", "ai", "of", "th", "pa"};
        StringSort.quickStringSort(lines);
        System.out.println("\nРезультат работы сортировки");
        for(int i = 0; i < lines.length; i++) {
            System.out.print(lines[i] + " ");
        }
        System.out.println();
    }
}

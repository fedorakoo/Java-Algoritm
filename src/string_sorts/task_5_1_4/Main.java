package string_sorts.task_5_1_4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static binary_search_tree.input.Input.inputInt;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Условие задания: Провести трассировку работы трехчастной бысторой сортировки для строковых ключей.");
        System.out.print("Введите количество строк, необходимых к проверке: ");
        int number = inputInt();
        List<String> lines = new LinkedList<>();
        for(int i = 0; i < number; i++) {
            System.out.print("Введите строку номер " + (i+1) + ": ");
            lines.add(in.nextLine());
        }
        StringSort.quickStringSort(lines);
        System.out.println("\nРезультат работы сортировки");
        for(int i = 0; i < number; i++) {
            System.out.println((i + 1) + ". " + lines.get(i));
        }
    }
}

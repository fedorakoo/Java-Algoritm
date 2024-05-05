package hash_table.task_3_4_17;

import java.util.Scanner;

import static binary_search_tree.input.Input.inputInt;
import static binary_search_tree.input.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Условие задания: Приведите результат использования метода delete() для удаления ключа из таблицы типа LinearProbingHashST со стандартным клиентом индексации.");
        LinearProbingHashST table = new LinearProbingHashST<>();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Удалить элемент\n" +
                    "3. Вывести таблицу\n" +
                    "4. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(4);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение ключа добавляемого элемента: ");
                    String key = in.nextLine();
                    System.out.print("Введите значение значение добавляемого элемента: ");
                    int value = inputInt();
                    table.put(key, value);
                    break;
                }
                case 2: {
                    System.out.print("Введите значение ключа удаляемого элемента: ");
                    String key = in.nextLine();
                    table.delete(key);
                    break;
                }
                case 3: {
                    table.output();
                    break;
                }
                default: {
                    break;
                }
            }
        } while (next != 4);
        System.out.println("Спасибо за внимание!");
    }
}

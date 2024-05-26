package trie_tree.task_5_2_20;

import java.util.Scanner;

import static binary_search_tree.input.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Добавьте в класс StringSet метод containsPrefix(), который принимает в качестве аргумента строку s и возвращает true, если множество содержит строку с префиксом s.");
        Scanner in = new Scanner(System.in);
        StringSET tree = new StringSET();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Удалить элемент\n" +
                    "3. Найти количество ключей дерева \n" +
                    "4. Выяснить, является ли дерево пустым\n" +
                    "5. Вывести все ключи дерева\n" +
                    "6. Выяснить, содержит ли множество строку с введенным префиксом\n" +
                    "7. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(7);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение ключа добавляемого элемента: ");
                    String value = in.nextLine();
                    tree.add(value);
                    break;
                }
                case 2: {
                    System.out.print("Введите значение ключа удаляемого элемента: ");
                    String value = in.nextLine();
                    tree.delete(value);
                    break;
                }
                case 3: {
                    System.out.println("Значение количества ключей дерева: " + tree.countWords());
                    break;
                }
                case 4: {
                    if(tree.isEmpty()) {
                        System.out.println("Дерево не содержит элементов");
                    }
                    else {
                        System.out.println("Дерево содержит в себе элементы");
                    }
                    break;
                }
                case 5: {
                    if(tree.toString().equals("")) {
                        System.out.println("Дерево не содержит в себе элементов");
                    }
                    else {
                        System.out.println("Ключи дерева: " + tree.toString());
                    }
                    break;
                }
                case 6: {
                    System.out.print("Введите значение строки: ");
                    String line = in.nextLine();
                    if(tree.containsPrefix(line)) {
                        System.out.println("Множество содержит строку с введеной строкой");
                    }
                    else {
                        System.out.println("Множество не содержит строки с введеной строкой");
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (next != 7);
        System.out.println("Спасибо за внимание!");
    }
}

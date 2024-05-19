package trie_tree.task_5_2_5;

import java.util.Scanner;

import static binary_search_tree.input.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: ");
        Scanner in = new Scanner(System.in);
        TrieST treeST = new TrieST();
        TST treeTST = new TST();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Удалить элемент\n" +
                    "3. Найти количество ключей дерева\n" +
                    "4. Выяснить, является ли дерево пустым\n" +
                    "5. Вывести все ключи дерева\n" +
                    "6. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(6);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение ключа добавляемого элемента: ");
                    String value = in.nextLine();
                    System.out.print("TrieST: ");
                    treeST.add(value);
                    System.out.print("TST: ");
                    treeTST.add(value);
                    break;
                }
                case 2: {
                    System.out.print("Введите значение ключа удаляемого элемента: ");
                    String value = in.nextLine();
                    System.out.print("TrieST: ");
                    treeST.delete(value);
                    System.out.print("TST: ");
                    treeTST.delete(value);
                    break;
                }
                case 3: {
                    System.out.println("TrieST: Значение количества ключей дерева: " + treeST.countWords());
                    System.out.println("TST: Значение количества ключей дерева: " + treeST.countWords());
                    break;
                }
                case 4: {
                    if(treeST.isEmpty()) {
                        System.out.println("TrieST: Дерево не содержит в себе элементов");
                    }
                    else {
                        System.out.println("TrieST: Дерево содержит в себе элементы");
                    }
                    if(treeTST.isEmpty()) {
                        System.out.println("TST: Дерево не содержит в себе элементов");
                    }
                    else {
                        System.out.println("TST: Дерево содержит в себе элементы");
                    }
                    break;
                }
                case 5: {
                    if(treeST.toString().equals("")) {
                        System.out.println("TreeST: Дерево не содержит в себе элементов");
                    }
                    else {
                        System.out.println("TreeST: Ключи дерева: " + treeST.toString());
                    }
                    if(treeTST.toString().equals("")) {
                        System.out.println("TST: Дерево не содержит в себе элементов");
                    }
                    else {
                        System.out.println("TST: Ключи дерева: " + treeST.toString());
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (next != 6);
        System.out.println("Спасибо за внимание!");
    }
}

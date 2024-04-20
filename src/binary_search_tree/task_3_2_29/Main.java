package binary_search_tree.task_3_2_29;

import java.util.Scanner;

import static binary_search_tree.task_3_2_29.BinarySearchTree.isBinaryTree;

public class Main {
    private static int inputIntLimit(int limit) {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumberInteger(number) || Integer.parseInt(number) <= 0 || Integer.parseInt(number) > limit) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }
    private static int inputInt() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumberInteger(number)) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }
    private static boolean isNumberInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите рекурсивный метод isBinaryTree(), который принимает в качестве аргумента узер Node и возвращает true, если счетчик проверки узлов верен, и false в ином случаи.");
        BinarySearchTree tree = new BinarySearchTree();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Удалить элемент\n" +
                    "3. Найти высоту дерева\n" +
                    "4. Вывести все элементы дерева\n" +
                    "5. Проверить, является ли структура деревом\n" +
                    "6. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(6);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    int value = inputInt();
                    tree.setParent(tree.insert(tree.getParent(), value));
                    break;
                }
                case 2: {
                    System.out.print("Введите значение удаляемого элемента: ");
                    int value = inputInt();
                    tree.setParent(tree.delete(tree.getParent(), value));
                    break;
                }
                case 3: {
                    System.out.print("Значение высоты дерева: " + tree.height(tree.getParent()) + "\n");
                    break;
                }
                case 4: {
                    System.out.print("Элементы дерева: ");
                    tree.printTree(tree.getParent());
                    break;
                }
                case 5: {
                    boolean isTree = isBinaryTree(tree.getParent());
                    if (isTree) {
                        System.out.println("Данная структрура является корректным бинарным деревом поиска");
                    }
                    else {
                        System.out.println("Данная структрура не является корректным бинарным деревом поиска");
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


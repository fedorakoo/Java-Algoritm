package binary_search_tree.task_3_2_6;

import java.util.Scanner;

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
        BinarySearchTree tree = new BinarySearchTree();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Удалить элемент\n" +
                    "3. Найти высоту дерева [height] \n" +
                    "4. Найти высоту дерева [size]\n" +
                    "5. Вывести все элементы дерева\n" +
                    "6. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(6);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    int value = inputInt();
                    tree.parent = tree.insert(tree.parent, value);
                    break;
                }
                case 2: {
                    System.out.print("Введите значение удаляемого элемента: ");
                    int value = inputInt();
                    tree.parent = tree.delete(tree.parent, value);
                    break;
                }
                case 3: {
                    System.out.print("Значение высоты дерева [height]: " + tree.height(tree.parent) + "\n");
                    break;
                }
                case 4: {
                    System.out.print("Значение высоты дерева [size]: " + tree.size() + "\n");
                    break;
                }
                case 5: {
                    System.out.print("Элементы дерева: ");
                    tree.printTree(tree.parent);
                    break;
                }
                default: {
                    
                }
            }
        } while (next != 6);
    }
}


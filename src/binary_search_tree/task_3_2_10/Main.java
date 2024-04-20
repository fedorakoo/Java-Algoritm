package binary_search_tree.task_3_2_10;

import java.util.List;
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
                    "3. Найти высоту дерева\n" +
                    "4. Найти количество элементов\n" +
                    "5. Найти минимальный элемент\n" +
                    "6. Найти максимальный элемент\n" +
                    "7. Удалить минимальный элемент\n" +
                    "8. Удалить максимальный элемент\n" +
                    "9. Найти пол дерева по значению\n" +
                    "10.Найти потолок дерева по значению\n" +
                    "11.Найти элемент дерева\n" +
                    "12.Найти ранг узла дерева по значению\n" +
                    "13.Найти элементы в заданном диапазоне\n" +
                    "14.Вывести все элементы дерева\n" +
                    "15.Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(15);
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
                    System.out.print("Значение высоты дерева: " + tree.height(tree.parent) + "\n");
                    break;
                }
                case 4: {
                    System.out.print("Значение количества элементов дерева: " + tree.size(tree.parent) + "\n");
                    break;
                }
                case 5: {
                    if(tree.min(tree.parent) == null) {
                        System.out.print("Минимального элемента нет\n");
                    }
                    else {
                        System.out.print("Значение минимального элемента дерева: " + tree.min(tree.parent).key + "\n");
                    }
                    break;
                }
                case 6: {
                    if(tree.min(tree.parent) == null) {
                        System.out.print("Максимального элемента нет\n");
                    }
                    else {
                        System.out.print("Значение максимального элемента дерева: " + tree.max(tree.parent).key + "\n");
                    }
                    break;
                }
                case 7: {
                    tree.deleteMin();
                    break;
                }
                case 8: {
                    tree.deleteMax();
                    break;
                }
                case 9: {
                    System.out.print("Введите значение: ");
                    int value = inputInt();
                    if(tree.floor(tree.parent, value) == null) {
                        System.out.print("Элемента нет\n");
                    }
                    else {
                        System.out.print("Значение максимального элемента дерева: " + tree.floor(tree.parent, value).key + "\n");
                    }
                    break;
                }
                case 10: {
                    System.out.print("Введите значение: ");
                    int value = inputInt();
                    if(tree.ceiling(tree.parent, value) == null) {
                        System.out.print("Элемента нет\n");
                    }
                    else {
                        System.out.print("Значение максимального элемента дерева: " + tree.ceiling(tree.parent, value).key + "\n");
                    }
                    break;
                }
                case 11: {
                    System.out.print("Введите значение: ");
                    int value = inputInt();
                    BinarySearchTree.Node select = tree.select(tree.parent, value);
                    System.out.print((select == null ? "Данный элемент не найден" : "Данный элемент найден"));
                    break;
                }
                case 12: {
                    System.out.print("Введите значение: ");
                    int value = inputInt();
                    System.out.print("Значение ранга равно " + tree.rank(tree.parent, value));
                    break;
                }
                case 13: {
                    System.out.print("Введите значение левого ограничения: ");
                    int valueLeft = inputInt();
                    System.out.print("Введите значение правого ограничения: ");
                    int valueRight = inputInt();
                    List<Integer> result = tree.keys(tree.parent, valueLeft, valueRight);
                    System.out.print("Список элементов: ");
                    for(int i = 0; i < result.size(); i++) {
                        System.out.print(result.get(i) + " ");
                    }
                    break;
                }
                case 14: {
                    tree.printTree(tree.parent);
                    break;
                }
                default: {
                    break;
                }
            }
        } while (next != 15);
    }
    void printInput(){
        
    }
}


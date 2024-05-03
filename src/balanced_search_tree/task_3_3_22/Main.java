package balanced_search_tree.task_3_3_22;

import java.util.Collections;
import java.util.List;

import static binary_search_tree.input.Input.inputInt;
import static binary_search_tree.input.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите клиент тестирования для структуры: красно-черное бинарное дерево поиска.");
        RedBlackTree tree = new RedBlackTree();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Найти высоту дерева\n" +
                    "3. Найти количество элементов\n" +
                    "4. Найти минимальный элемент\n" +
                    "5. Найти максимальный элемент\n" +
                    "6. Найти пол дерева по значению\n" +
                    "7.Найти потолок дерева по значению\n" +
                    "8. Найти элемент дерева\n" +
                    "9. Найти ранг узла дерева по значению\n" +
                    "10.Найти элементы в заданном диапазоне\n" +
                    "11.Вывести все элементы дерева\n" +
                    "12.Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(15);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    int value = inputInt();
                    tree.insert(value);
                    break;
                }
                case 2: {
                    System.out.print("Значение высоты дерева: " + tree.height(tree.getParent()) + "\n");
                    break;
                }
                case 3: {
                    System.out.print("Значение количества элементов дерева: " + tree.size(tree.getParent()) + "\n");
                    break;
                }
                case 4: {
                    outputMinElement(tree);
                    break;
                }
                case 5: {
                    outputMaxElement(tree);
                    break;
                }
                case 6: {
                    outputTreeFlour(tree);
                    break;
                }
                case 7: {
                    outputCeilingElement(tree);
                    break;
                }
                case 8: {
                    outputInputInformation();
                    int value = inputInt();
                    RedBlackTree.Node select = tree.select(tree.getParent(), value);
                    System.out.print((select == RedBlackTree.nil ? "Данный элемент не найден" : "Данный элемент найден"));
                    break;
                }
                case 9: {
                    outputInputInformation();
                    int value = inputInt();
                    System.out.print("Значение ранга равно " + tree.rank(tree.getParent(), value));
                    break;
                }
                case 10: {
                    outputKeysTree(tree);
                    break;
                }
                case 11: {
                    RedBlackTree.printTree(tree.getParent());
                    break;
                }
                default: {
                    break;
                }
            }
            System.out.println();
        } while (next != 12);
        System.out.println("Спасибо за внимание!");
    }
    static void outputInputInformation() {
        System.out.print("Введите значение: ");
    }
    static void outputMinElement(RedBlackTree tree) {
        if(tree.min(tree.getParent()) == RedBlackTree.nil) {
            System.out.print("Минимального элемента нет\n");
        }
        else {
            System.out.print("Значение минимального элемента дерева: " + tree.min(tree.getParent()).key + "\n");
        }
    }
    static void outputMaxElement(RedBlackTree tree) {
        if(tree.min(tree.getParent()) == RedBlackTree.nil) {
            System.out.print("Максимального элемента нет\n");
        }
        else {
            System.out.print("Значение максимального элемента дерева: " + tree.max(tree.getParent()).key + "\n");
        }
    }
    static void outputTreeFlour(RedBlackTree tree) {
        outputInputInformation();
        int value = inputInt();
        if(tree.floor(tree.getParent(), value) == -1) {
            System.out.print("Элемента нет\n");
        }
        else {
            System.out.print("Значение 'пола' элемента дерева: " + tree.floor(tree.getParent(), value) + "\n");
        }
    }
    static void outputCeilingElement(RedBlackTree tree) {
        outputInputInformation();
        int value = inputInt();
        if(tree.ceiling(tree.getParent(), value) == -1) {
            System.out.print("Элемента нет\n");
        }
        else {
            System.out.print("Значение 'потолка' элемента дерева: " + tree.ceiling(tree.getParent(), value) + "\n");
        }
    }
    static void outputKeysTree(RedBlackTree tree) {
        System.out.print("Введите значение левого ограничения: ");
        int valueLeft = inputInt();
        System.out.print("Введите значение правого ограничения: ");
        int valueRight = inputInt();
        List<Integer> result = tree.keys(tree.getParent(), valueLeft, valueRight);
        Collections.sort(result);
        if (result.isEmpty()) {
            System.out.print("Элементов в заданном диапазоне нет");
        } else {
            System.out.print("Список элементов: ");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        }
    }
}

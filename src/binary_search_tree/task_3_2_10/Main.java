package binary_search_tree.task_3_2_10;

import java.util.List;

import static binary_search_tree.InputCheck.Input.inputInt;
import static binary_search_tree.InputCheck.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите клиент тестирования, включающий в себя функции min(), max(), floor(), ceiling(), select(), rank(), delete(), deleteMin(), deleteMax(), keys().");
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
                    System.out.print("Значение количества элементов дерева: " + tree.size(tree.getParent()) + "\n");
                    break;
                }
                case 5: {
                    if(tree.min(tree.getParent()) == null) {
                        System.out.print("Минимального элемента нет\n");
                    }
                    else {
                        System.out.print("Значение минимального элемента дерева: " + tree.min(tree.getParent()).key + "\n");
                    }
                    break;
                }
                case 6: {
                    if(tree.min(tree.getParent()) == null) {
                        System.out.print("Максимального элемента нет\n");
                    }
                    else {
                        System.out.print("Значение максимального элемента дерева: " + tree.max(tree.getParent()).key + "\n");
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
                    outputInputInformation();
                    int value = inputInt();
                    if(tree.floor(tree.getParent(), value) == -1) {
                        System.out.print("Элемента нет\n");
                    }
                    else {
                        System.out.print("Значение 'пола' элемента дерева: " + tree.floor(tree.getParent(), value) + "\n");
                    }
                    break;
                }
                case 10: {
                    outputInputInformation();
                    int value = inputInt();
                    if(tree.ceiling(tree.getParent(), value) == -1) {
                        System.out.print("Элемента нет\n");
                    }
                    else {
                        System.out.print("Значение 'потолка' элемента дерева: " + tree.ceiling(tree.getParent(), value) + "\n");
                    }
                    break;
                }
                case 11: {
                    outputInputInformation();
                    int value = inputInt();
                    BinarySearchTree.Node select = tree.select(tree.getParent(), value);
                    System.out.print((select == null ? "Данный элемент не найден" : "Данный элемент найден"));
                    break;
                }
                case 12: {
                    outputInputInformation();
                    int value = inputInt();
                    System.out.print("Значение ранга равно " + tree.rank(tree.getParent(), value));
                    break;
                }
                case 13: {
                    System.out.print("Введите значение левого ограничения: ");
                    int valueLeft = inputInt();
                    System.out.print("Введите значение правого ограничения: ");
                    int valueRight = inputInt();
                    List<Integer> result = tree.keys(tree.getParent(), valueLeft, valueRight);
                    if(result.isEmpty()) {
                        System.out.print("Элементов в заданном диапозоне нет");
                    }
                    else {
                        System.out.print("Список элементов: ");
                        for (int i = 0; i < result.size(); i++) {
                            System.out.print(result.get(i) + " ");
                        }
                    }
                    break;
                }
                case 14: {
                    BinarySearchTree.printTree(tree.getParent());
                    break;
                }
                default: {
                    break;
                }
            }
            System.out.println();
        } while (next != 15);
        System.out.println("Спасибо за внимание!");
    }
    static void outputInputInformation() {
        System.out.print("Введите значение: ");
    }
}


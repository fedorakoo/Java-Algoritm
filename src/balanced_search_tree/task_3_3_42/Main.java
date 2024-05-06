package balanced_search_tree.task_3_3_42;

import java.text.DecimalFormat;
import java.util.List;

import static binary_search_tree.input.Input.inputInt;
import static binary_search_tree.input.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: напишите программу, которая вычисляет процент красных узлов в заданном красно-черное ДБП");
        System.out.println("В результате нескольких запусков программы с различным количеством элементов дерева(N = 10³, 10⁵ и 10⁶), заполнение которого происхоло случайными элементами, было определено что процентное отношении красных узлов дерева к их общему количеству при больших значениях количества элементов примерно равно 47.5%, причем колебания результата составляют не более +-1.5%.");
        RedBlackTree tree = new RedBlackTree();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Вывести все элементы дерева\n" +
                    "3. Получить значение количества красных узлов\n" +
                    "4. Получить значение количества черных узлов\n" +
                    "5. Получить необходимое процентное соотношение\n" +
                    "6. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(6);
            switch (next) {
                case 1: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    int value = inputInt();
                    tree.insert(value);
                    break;
                }
                case 2: {
                    List<Integer> elements = tree.getListElement(tree.getParent());

                    for(int element : elements) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Значение количества красных элементов дерева: " + (tree.getNumberDifferentColor(tree.getParent()).first()));
                    break;
                }
                case 4: {
                    System.out.println("Значение количества черных элементов дерева: " + (tree.getNumberDifferentColor(tree.getParent()).second()));
                    break;
                }
                case 5: {
                    String formattedDouble =
                            new DecimalFormat("#0.00").format(tree.getPercentageRedElementsRedBlackTree(tree.getParent()));
                    System.out.println(formattedDouble);
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

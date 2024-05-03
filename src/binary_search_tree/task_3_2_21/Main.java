package binary_search_tree.task_3_2_21;

import static binary_search_tree.input.Input.inputInt;
import static binary_search_tree.input.Input.inputIntLimit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Добавьте в класс BST метод randomKey(), который возвращает из таблицы имен случайный ключ за время, в худшем случаи пропорциональный высоте дерева.");
        BinarySearchTree tree = new BinarySearchTree();
        int next;
        do {
            System.out.print("\n1. Добавить элемент\n" +
                    "2. Удалить элемент\n" +
                    "3. Найти высоту дерева\n" +
                    "4. Вывести все элементы дерева\n" +
                    "5. Вывести случайный элемент дерева\n" +
                    "6. Завершить работу\n");
            System.out.print("Введите вариант продолжения: ");
            next = inputIntLimit(7);
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
                    BinarySearchTree.printTree(tree.getParent());
                    break;
                }
                case 5: {
                    if(tree.getParent() == null) {
                        System.out.println("Дерево не имеет элементов");
                    }
                    else {
                        System.out.println("Случайный ключ бинарного дерева поиска: " + tree.randomKey(tree.getParent()));
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


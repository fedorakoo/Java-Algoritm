package containers_queues_stacks.task_1_3_33;

import java.util.Scanner;

public class Main {
    private static int inputInt() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumber(number)) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }

    private static int inputIntLimitation(int leftLimit, int rightLimit) {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumber(number) || !(Integer.parseInt(number) <= rightLimit && Integer.parseInt(number) >= leftLimit)) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Условие задания: Дек. Очередь с двумя концами, или дек, похожа на стек или очередь, но поддерживает добавление и удаление элементов с обоих концов. Дек хранит коллекцию элементов и поддерживает следующий АРI-интерфейс:\n" + "Количество элементов в деке\n" + "Добавление элемента с левого конца\n" + "Добавление элемента с правого конца\n" + "Удаление элемента с левого конца\n" + "Удаление элемента с правого конца\n" + "Реализуйте данный API-интерфейс\n\n");
        int dialogMenu;
        System.out.print("Введите размер создаваемого массива: ");
        int size;
        size = inputInt();
        Deque<String> arr = new Deque<>(size);
        arr.inputArray();
        do {
            System.out.println("\n1.Изменение размера массива\n" + "2.Узнать, пустой ли массив\n" + "3.Получить значение размера массива\n" + "4.Добавить элемент слева\n" + "5.Добавить элемент справа\n" + "6.Удалить элемент слева\n" + "7.Удалить элемент справа\n" + "8.Изменить значение элемента массива\n" + "9.Вывести массив\n" + "10.Выход\n");
            System.out.print("Введите продолжение: ");
            dialogMenu = inputIntLimitation(0, 10);
            switch (dialogMenu) {
                case 1: {
                    System.out.print("Введите новый размер массива: ");
                    int newSize = inputInt();
                    arr = new Deque<>(newSize);
                    arr.inputArray();
                    arr.ouputArray();
                    break;
                }
                case 2: {
                    System.out.println(arr.isEmpty() ? "Массив является пустым" : "Массив не является пустым");
                    break;
                }
                case 3: {
                    System.out.println("Размер массива: " + arr.getSize());
                    break;
                }
                case 4: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    String valueAddElement = in.nextLine();
                    arr.pushLeft(valueAddElement);
                    break;
                }
                case 5: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    String valueAddElement = in.nextLine();
                    arr.pushRight(valueAddElement);
                    break;
                }
                case 6: {
                    System.out.println("Значение удаляемого элемента: " + arr.popLeft());
                    break;
                }
                case 7: {
                    System.out.println("Значение удаляемого элемента: " + arr.popRight());
                    break;
                }
                case 8: {
                    int sizeArr = arr.getSize();
                    System.out.print("Введите номер изменяемого элемента: ");
                    int ptrChange = inputIntLimitation(0, sizeArr - 1);
                    System.out.print("Введите новое значение элемента: ");
                    String changeElement = in.nextLine();
                    arr.changeElement(changeElement, ptrChange);
                    arr.ouputArray();
                    break;
                }
                case 9: {
                    arr.ouputArray();
                    break;
                }
                default: {
                    dialogMenu = 0;
                }
            }
        } while (dialogMenu != 0);
    }
}
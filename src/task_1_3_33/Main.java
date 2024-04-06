package task_1_3_33;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dialogMenu = 0;
        System.out.print("Введите размер создаваемого массива: ");
        int size = in.nextInt();
        Degue<String> arr = new Degue<>(size);
        arr.inputArray();
        do {
            System.out.println("\n1.Изменение размера массива\n" +
                    "2.Узнать, пустой ли массив\n" +
                    "3.Получить значение размера массива\n" +
                    "4.Добавить элемент слево\n" +
                    "5.Добавить элемент справо\n" +
                    "6.Удалить элемент слево\n" +
                    "7.Удалить элемент справо\n" +
                    "8.Ввести новое значение массива\n" +
                    "9.Вывести массив\n" +
                    "10.Выход\n");
            System.out.print("Введите продолжение: ");

            dialogMenu = in.nextInt();
            switch (dialogMenu) {
                case 1: {
                    System.out.print("Введите новый размер массива: ");
                    int newSize = in.nextInt();
                    arr = new Degue<>(newSize);
                    arr.inputArray();
                    break;
                }
                case 2: {
                    System.out.println("Пуст ли массив?:" + arr.isEmpty());
                    break;
                }
                case 3: {
                    System.out.println("Размер массива:" + arr.getSize());
                    break;
                }
                case 4: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    String valueAddElement = in.next();
                    arr.pushLeft(valueAddElement);
                    break;
                }
                case 5: {
                    System.out.print("Введите значение добавляемого элемента: ");
                    String valueAddElement = in.next();
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
                    arr.inputArray();
                    break;
                }
                case 9: {
                    System.out.print("Значение всех элементов в массиве: " + arr.ouputArray());
                    break;
                }
                case 10: {
                    dialogMenu = 0;
                }
            };
        } while (dialogMenu != 0);
    }
}
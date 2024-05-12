package string_sorts.task_5_1_14;

import java.util.ArrayList;
import java.util.List;

import static binary_search_tree.input.Input.inputInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Разработайте метод, в котором трехчасная быстрая сортировка строк применяется для ключей, представляющих собой массивы целых чисел.");
        System.out.print("Введите количество массивов, необходимых к сортировке: ");
        int number = inputInt();
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            System.out.print("Введите количество элементов массива номер " + (i + 1) + ": ");
            int size = inputInt();
            List<Integer> array = new ArrayList<>();
            for(int t = 0; t < size; t++) {
                System.out.print("Введите значение элемента массива " + (i + 1) + " под номером " + (t+1) + ": ");
                array.add(inputInt());
            }
            arr.add(array);
        }
        Sort.quickTwoDimensionalArraySort(arr);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print("\nЗначения элементов массива номер " + (i + 1) + ":");
            List<Integer> list = arr.get(i);
            for(int t  = 0; t < list.size(); t++) {
                System.out.print(" " + list.get(t));
            }
        }
    }
}

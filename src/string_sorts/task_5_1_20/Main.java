package string_sorts.task_5_1_20;

import string_sorts.task_5_1_19.Sort;
import java.util.List;

import static binary_search_tree.input.Input.inputInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите статический метод, который принимает в качестве аргументов целочисленные значения N и W и возвращает массив N строковых значений из W символов алфавита.");
        System.out.print("Введите количество необходимых слов: ");
        int number = inputInt();
        System.out.print("Введите количество символов каждого слова: ");
        int size = inputInt();
        List<String> arr = RandomString.getRandomArrayWords(number, size);
        Sort.sort(arr);
        for(int i = 0; i < arr.size(); i++) {
            System.out.println("Сгенерированнный слово номер " + (i+1) + ": " + arr.get(i));
        }
    }
}

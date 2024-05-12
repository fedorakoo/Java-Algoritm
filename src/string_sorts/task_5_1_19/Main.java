package string_sorts.task_5_1_19;

import java.util.List;

import static binary_search_tree.input.Input.inputInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите статический метод, который принимает в качестве аргумента целое значение N и возвращает массив из N значений типа String, которые представляют собой автомобильные номера приведенные в примерах раздела");
        System.out.print("Введите количество необходимых автомобильных номеров: ");
        int number = inputInt();
        List<String> arr = RandomDecimalKeys.getRandomArrayCarNumber(number);
        Sort.sort(arr);
        for(int i = 0; i < arr.size(); i++) {
            System.out.println("Сгенерированнный автомобильный номер под номером " + (i+1) + ": " + arr.get(i));
        }
    }
}

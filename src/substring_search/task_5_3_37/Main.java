package substring_search.task_5_3_37;

import binary_search_tree.input.Input;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Условие задания: Напишите клиент, который принимает в качестве входных параметров целые значения M, N и T и выполняет T раз следующий эксперимент. Генерируется случайный образец длиной M и случайный текст длиной N, а затем подсчитывается количество сравнений символов при поиске образца в тексте с помощью реализации КМП. Добавьте в класс КМП возможность подсчета сравнений и выведите среднее значение для T повторений.");
        System.out.print("Введите количество экспериментов: ");
        int t = Input.inputInt();
        System.out.print("Введите количество символов в тексте: ");
        int n = Input.inputInt();
        System.out.print("Введите количество символов в подстроке: ");
        int m = Input.inputInt();
        List<Integer> result = new ArrayList<>();
        double total = 0;
        for(int i = 0; i < t; i++) {
            String text = getRandLine(n);
            String substr = getRandLine(m);
            result.add(KMP.searchKMP(substr, text));
            total += result.get(result.size() - 1);
            System.out.println("Значение сравнений эксперимента номер " + (i + 1) + " равно: " + result.get(result.size() - 1));
        }
        System.out.println("Среднее значение сравнений равно: " + total / result.size());
    }
    static String getRandLine(int size) {
        StringBuilder bld = new StringBuilder();
        while(size != 0) {
            bld.append((char)random.nextInt('a',  'z' + 1));
            size--;
        }
        return bld.toString();
    }
    static Random random = new SecureRandom();
}

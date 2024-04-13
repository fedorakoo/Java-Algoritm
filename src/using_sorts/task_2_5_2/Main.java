package using_sorts.task_2_5_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите программу, которая читает из стандартного ввода список слов и выводит все составные слова, состоящие из двух слов.");
        System.out.print("Введите количество вводимых слов: ");
        Scanner in = new Scanner(System.in);
        int numberWord = in.nextInt();
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < numberWord; i++) {
            System.out.print("Введите слово под номером " + (i + 1) + ": ");
            words.add(in.next());
        }
        Collections.sort(words);
        System.out.println("Слова, являющиеся составными: ");
        System.out.print(FindCompound.findCompound(words));
    }
}
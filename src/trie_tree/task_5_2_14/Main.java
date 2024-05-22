package trie_tree.task_5_2_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static using_sorts.task_2_5_13.Input.inputInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите клиент TST.java, который выводит текст из стандартного ввода и подсчитывает в нем количество уникальных подстрок длиной L. Например, входной текст cgcgggcgcg содержит пять уникальных подстрок длиной 3: cgc, gcg, cgg, ggg и ggc.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение строки: ");
        String line = in.nextLine();
        TST tree = new TST();
        int length;
        System.out.print("Введите количество символов в подстроке: ");
        length = inputInt();
        tree.put(line);
        List<String> set = tree.getSubstrings();
        List<String> result = new ArrayList<>();
        for (String str : set) {
            if (str.length() == length) {
                result.add(str);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Данных подстрок нет");
        } else {
            System.out.print("Значения подстрок: ");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println("Значение количества уникальных подстрок: " + result.size());
    }
}

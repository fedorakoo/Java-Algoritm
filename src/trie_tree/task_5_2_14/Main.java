package trie_tree.task_5_2_14;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите клиент TST.java, который выводит текст из стандартного ввода и подсчитывает в нем количество уникальных подстрок длиной L. Например, входной текст cgcgggcgcg содержит пять уникальных подстрок длиной 3: cgc, gcg, cgg, ggg и ggc.");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TST tree = new TST();
        tree.put(line);
        List<String> set = tree.getSubstrings();
        boolean isSuitable = true;
        int size = 1;
        while(isSuitable) {
            isSuitable = false;
            for (String number : set) {
                if(number.length() == size) {
                    isSuitable = true;
                    System.out.println(number);
                }
            }
            size++;
        }
    }
}

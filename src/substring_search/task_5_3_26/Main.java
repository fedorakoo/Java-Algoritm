package substring_search.task_5_3_26;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Условие задания: Напишите программу, которая для заданных двух строк определит, является ли одна из них циклической перестановкой другой – например, пальто и топаль.");
        System.out.print("Введите строку номер один: ");
        String first = in.nextLine();
        System.out.print("Введите строку номер два: ");
        String second = in.nextLine();
        if(CyclicPermutations.isPermutation(first, second)) {
            System.out.println("Введенные строки являются циклическими перестановками друг друга");
        }
        else {
            System.out.println("Введенные строки не являются циклическими перестановками друг друга");
        }
    }
}
package using_sorts.task_2_5_16;

import java.util.ArrayList;
import java.util.Scanner;

public class California {
    public static void main(String[] args) {
        StringBuilder bld = new StringBuilder();
        System.out.println("Условие задания: Выборы без предпочтений. Чтобы не ущемлять кандидатов, имена которых находятся в конце алфавита, на выборах губернатора Калифорнии в 2003 г. их упорядочили с помощью определенного набора латинских символов. Напишите клиент California с единственным статическим методом main(), который упорядочивает строки в таком порядке. Считайте, что все строки содержат только прописные буквы.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество кандидатов: ");
        int number = in.nextInt();
        final int SIZE_ENGLISH_ALPHABET = 26;
        ArrayList<String> candidates = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            System.out.print("Введите фамилию кандидата номер " + (i + 1) + ". ");
            candidates.add(in.next());
        }
        int[] arrLetterToSort = {'r', 'w', 'q', 'o', 'j', 'm', 'v', 'a', 'h', 'b', 's', 'g', 'z', 'x', 'n', 't', 'c', 'i', 'e', 'k', 'u', 'p', 'd', 'y', 'f', 'l'};
        int[] letterPower = new int[SIZE_ENGLISH_ALPHABET];
        for (int i = 0; i < SIZE_ENGLISH_ALPHABET; i++) {
            for (int t = 0; t < SIZE_ENGLISH_ALPHABET; t++) {
                if (arrLetterToSort[t] == 'a' + i) {
                    letterPower[i] = t;
                    break;
                }
            }
        }
        boolean isArrSorted = true;
        for (int t = 0; t < candidates.size() && !isArrSorted; t++) {
            isArrSorted = true;
            for (int i = 1; i < candidates.size(); i++) {
                boolean isFirstLineMoreThanSecond = true;
                for (int j = 0; j < candidates.get(i).length() && j < candidates.get(i - 1).length() && isFirstLineMoreThanSecond; j++) {
                    if (letterPower[candidates.get(i).charAt(j) - 'a'] > letterPower[candidates.get(i - 1).charAt(j) - 'a']) {
                        break;
                    }
                    if (letterPower[candidates.get(i).charAt(j) - 'a'] < letterPower[candidates.get(i - 1).charAt(j) - 'a']) {
                        isFirstLineMoreThanSecond = false;
                    }
                    else if (j + 1 == candidates.get(i).length() || j + 1 == candidates.get(i - 1).length()) {
                        isFirstLineMoreThanSecond = (candidates.get(i).length() > candidates.get(i - 1).length());
                        break;
                    }
                }
                if (!isFirstLineMoreThanSecond) {
                    String change = candidates.get(i);
                    candidates.set(i, candidates.get(i - 1));
                    candidates.set(i - 1, change);
                    isArrSorted = false;
                }
            }
        }

        System.out.println("Конечный список кандидатов:");
        for (int i = 0; i < candidates.size(); i++) {
            bld.append(String.valueOf(i + 1) + "." + candidates.get(i) + "\n");
        }
        System.out.println(bld);
    }
}
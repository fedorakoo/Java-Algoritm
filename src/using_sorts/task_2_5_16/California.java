package using_sorts.task_2_5_16;

import java.util.ArrayList;
import java.util.Scanner;

public class California {
    public static void main(String[] args) {
        System.out.println("Условие задания: Выборы без предпочтений. Чтобы не ущемлять кандидатов, имена которых находятся в конце алфавита, на выборах губернатора Калифорнии в 2003 г. их упорядочили с помощью определенного набора символов. Напишите клиент California с единственным статическим методом main(), который упорядочивает строки в таком порядке. Считайте, что все строки содержат только прописные буквы.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество кандидатов: ");
        int number = in.nextInt();
        final int SizeEnglishAlphabet = 26;
        ArrayList<String> arrCandidate = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            System.out.print("Введите фамилию кандидата номер " + (i + 1) + ". ");
            arrCandidate.add(in.next());
        }
        int[] arrLetterToSort = {'r', 'w', 'q', 'o', 'j', 'm', 'v', 'a', 'h', 'b', 's', 'g', 'z', 'x', 'n', 't', 'c', 'i', 'e', 'k', 'u', 'p', 'd', 'y', 'f', 'l'};
        int[] letterPower = new int[SizeEnglishAlphabet];
        for (int i = 0; i < SizeEnglishAlphabet; i++) {
            for (int t = 0; t < SizeEnglishAlphabet; t++) {
                if (arrLetterToSort[t] == 'a' + i) {
                    letterPower[i] = t;
                    break;
                }
            }
        }
        for (int t = 0; t < arrCandidate.size(); t++) {
            for (int i = 1; i < arrCandidate.size(); i++) {
                boolean isFirstLineMoreThanSecond = true;
                for (int j = 0; j < arrCandidate.get(i).length() && j < arrCandidate.get(i - 1).length() && isFirstLineMoreThanSecond; j++) {
                    if (letterPower[arrCandidate.get(i).charAt(j) - 'a'] > letterPower[arrCandidate.get(i - 1).charAt(j) - 'a']) {
                        break;
                    }
                    if (letterPower[arrCandidate.get(i).charAt(j) - 'a'] < letterPower[arrCandidate.get(i - 1).charAt(j) - 'a']) {
                        isFirstLineMoreThanSecond = false;
                    } else if (j + 1 == arrCandidate.get(i).length() || j + 1 == arrCandidate.get(i - 1).length()) {
                        isFirstLineMoreThanSecond = (arrCandidate.get(i).length() > arrCandidate.get(i - 1).length());
                        break;
                    }
                }
                if (!isFirstLineMoreThanSecond) {
                    String change = arrCandidate.get(i);
                    arrCandidate.set(i, arrCandidate.get(i - 1));
                    arrCandidate.set(i - 1, change);
                }
            }
        }

        System.out.println("Конечный список кандидатов:");
        for (int i = 0; i < arrCandidate.size(); i++) {
            System.out.println(String.valueOf(i + 1) + '.' + arrCandidate.get(i));
        }
    }
}
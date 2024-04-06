package task_2_5_2;

import java.util.Scanner;
import java.util.Vector;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество кандидатов: ");
        int number = in.nextInt();
        final int SizeEnglishAlphabet = 26;
        Vector<String> arrCandidate = new Vector<String>();
        for (int i = 0; i < number; i++) {
            System.out.print("Введите фамилию кандидата номер " + String.valueOf(i + 1) + ". ");
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
                for (int j = 0; j < arrCandidate.get(i).length() && j < arrCandidate.get(i - 1).length(); j++) {
                    if (letterPower[arrCandidate.get(i).charAt(j) - 'a'] > letterPower[arrCandidate.get(i - 1).charAt(j) - 'a']) {
                        isFirstLineMoreThanSecond = true;
                        break;
                    }
                    if (letterPower[arrCandidate.get(i).charAt(j) - 'a'] < letterPower[arrCandidate.get(i - 1).charAt(j) - 'a']) {
                        isFirstLineMoreThanSecond = false;
                        break;
                    } else if (j + 1 == arrCandidate.get(i).length() || j + 1 == arrCandidate.get(i - 1).length()) {
                        isFirstLineMoreThanSecond = ((arrCandidate.get(i).length() > arrCandidate.get(i - 1).length()) ? true : false);
                        break;
                    }
                }
                if (isFirstLineMoreThanSecond == false) {
                    String change = arrCandidate.get(i);
                    arrCandidate.set(i, arrCandidate.get(i - 1));
                    arrCandidate.set(i - 1, change);
                }
            }
        }

        System.out.println("---------------------------\n" +
                "Конечный список кондидатов\n" +
                "---------------------------");
        for (int i = 0; i < arrCandidate.size(); i++) {
            System.out.println(String.valueOf(i + 1) + '.' + arrCandidate.get(i));
        }
    }
}
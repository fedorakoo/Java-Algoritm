package containers_queues_stacks.task_1_3_4;

import java.util.Scanner;

public class Main {

    private static boolean isInputLineCorrect(String input) {
        for (char c : input.toCharArray()) {
            if (!(c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']')) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку, состоящую из скобок, необходимую к проверке: ");
        String line = in.nextLine();
        if(isInputLineCorrect(line)) {
            System.out.print(Parentheses.isBracketsCorrect(line) ?
                    "Расстановка символов в данной строке является корректной" :
                    "Расстановка символов в данной строке является некорректной");
        }
        else {
            System.out.print("Произошла ошибка при вводе строки!");
        }
    }
}
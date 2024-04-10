package containers_queues_stacks.task_1_3_10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import static containers_queues_stacks.task_1_3_10.Transformation.isSymbolNumber;
import static containers_queues_stacks.task_1_3_10.Transformation.isSymbolOperation;

public class Main {
    private static boolean checkBrackets(String input) {
        Deque<Character> stackBrackets = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stackBrackets.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                if (stackBrackets.isEmpty()) {
                    return false;
                } else {
                    stackBrackets.pop();
                }
            }
        }
        return stackBrackets.isEmpty();
    }

    private static boolean isLineCorrect(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(isSymbolNumber(input, i) || isSymbolOperation(input, i))) {
                return false;
            }
        }
        return checkBrackets(input);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Условие задания: Напишите фильтр InfixToPostfix, который преобразует арифметическое выражение из инфиксного в постфиксное\n" +
                "Введите значение выражения, для преобразования его в посфиксную форму: ");
        String inputLine = in.nextLine();
        if (isLineCorrect(inputLine)) {
            System.out.print(Transformation.toPostfix(inputLine));
        } else {
            System.out.println("Введите корректное значение строки!");
        }
    }
}

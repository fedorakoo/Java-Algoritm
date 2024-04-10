package containers_queues_stacks.task_1_3_4;

import java.util.Deque;
import java.util.LinkedList;

public class Parentheses {
    private Parentheses() {

    }

    public static boolean isBracketsCorrect(String lineCheck) {
        Deque<Character> stackBrackets = new LinkedList<>();
        for (int i = 0; i < lineCheck.length(); i++) {
            if (isOpeningBracked(lineCheck.charAt(i))) {
                stackBrackets.push(lineCheck.charAt(i));
            } else if (stackBrackets.isEmpty() || !isOppositeBracket(lineCheck.charAt(i), stackBrackets.pop())) {
                return false;
            }
        }
        return stackBrackets.isEmpty();
    }

    private static boolean isOpeningBracked(char charCheck) {
        return (charCheck == '(' || charCheck == '[' || charCheck == '{');
    }

    private static boolean isOppositeBracket(char firstBracket, char secondBracked) {
        if (firstBracket > secondBracked) {
            char temp = firstBracket;
            firstBracket = secondBracked;
            secondBracked = temp;
        }
        return (firstBracket == '(' && secondBracked == ')' ||
                firstBracket == '[' && secondBracked == ']' ||
                firstBracket == '{' && secondBracked == '}');
    }
}
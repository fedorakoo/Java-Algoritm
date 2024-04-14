package containers_queues_stacks.task_1_3_10;

import java.util.*;

public class Transformation {
    private Transformation() {

    }
    public static String toPostfix(String line) {
        StringBuilder bld = new StringBuilder();
        Deque<Character> stackArithmeticOperation = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            if(isSymbolNumber(line, i)) {
                bld.append(line.charAt(i));
            }
            else if (isSymbolOperation(line, i)) {
                if (isAddAtFirst(stackArithmeticOperation, line, i)) {
                    stackArithmeticOperation.push(line.charAt(i));
                    continue;
                } else if (line.charAt(i) == ')') {
                    while (isNoOpenBracket(stackArithmeticOperation)) {
                        bld.append(addSymbolsOperation(stackArithmeticOperation.pop()));
                    }
                    stackArithmeticOperation.pop();
                    stackArithmeticOperation.push(line.charAt(i));
                    continue;
                }
                while (continueAddSymbolsOperation(stackArithmeticOperation, line, i)) {
                    bld.append(addSymbolsOperation(stackArithmeticOperation.pop()));
                }
                stackArithmeticOperation.push(line.charAt(i));
            }
        }
        bld.append(addResidual(stackArithmeticOperation));
        return bld.toString();
    }

    private static boolean isAddAtFirst(Deque<Character> stackArithmeticOperation, String line, int i) {
        return !(continueAddSymbolsOperation(stackArithmeticOperation, line, i) ||
                line.charAt(i) == ')');
    }

    private static String addResidual(Deque<Character> stackArithmeticOperation) {
        StringBuilder bld = new StringBuilder();
        while (!stackArithmeticOperation.isEmpty()) {
            if (!isBracketOfOperation(stackArithmeticOperation.peek()))
                bld.append(" "+ stackArithmeticOperation.pop() + " ");
            else stackArithmeticOperation.pop();
        }
        return bld.toString();
    }

    public static boolean isSymbolNumber(String line, int i) {
        if (i < line.length()) {
            char symbol = line.charAt(i);
            return (symbol <= '9' && symbol >= '0');
        }
        return false;
    }

    private static boolean isNoOpenBracket(Deque<Character> stackArithmeticOperation) {
        return (!stackArithmeticOperation.isEmpty() &&
                stackArithmeticOperation.peek() != '(');
    }

    public static boolean isSymbolOperation(String line, int i) {
        if (i < line.length()) {
            char symbol = line.charAt(i);
            return (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '(' ||
                    symbol == ')');
        }
        return false;
    }

    private static int getOperationPriority(char typeOfOperation) {
        if (typeOfOperation == '*' || typeOfOperation == '/') {
            return 2;
        } else if (typeOfOperation == '+' || typeOfOperation == '-') {
            return 1;
        }
        return 3;
    }

    private static String addSymbolsOperation(char operation) {
        if (operation != '(' && operation != ')') {
            return " " + operation + " ";
        }
        return "";
    }

    private static boolean continueAddSymbolsOperation(Deque<Character> stackArithmeticOperation, String line, int i) {
        if (!stackArithmeticOperation.isEmpty() && stackArithmeticOperation.peek() == '(') {
            return false;
        }
        return (!stackArithmeticOperation.isEmpty() &&
                getOperationPriority(line.charAt(i)) <= getOperationPriority(stackArithmeticOperation.peek()));
    }

    private static boolean isBracketOfOperation(char firstOperation) {
        return (firstOperation == '(' ||
                firstOperation == ')');
    }
}

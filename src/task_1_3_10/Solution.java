package org.task_1_3_10;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution
{
    Solution() {

    }
    public static String infixToPostfix(String line) {
        Deque<Character> stackArithmeticOperation = new ArrayDeque<>();
        StringBuilder bld = new StringBuilder();
        for(int i = 0; i < line.length(); i++) {
            if(isSymbolOperation(line.charAt(i))) {
                if(!stackArithmeticOperation.isEmpty() &&
                      getOperationPriority(line.charAt(i))
                              > getOperationPriority(stackArithmeticOperation.peek())) {
                    while(!stackArithmeticOperation.isEmpty() &&
                          getOperationPriority(line.charAt(i))
                                  >= getOperationPriority(stackArithmeticOperation.peek())) {
                        bld.append(stackArithmeticOperation.pop() + " ");
                    }
                }
                stackArithmeticOperation.push(line.charAt(i));
            }
            else if(isSymbolNumber(line.charAt(i))) {
                int numberSize = 0;
                while(i + numberSize < line.length() && isSymbolNumber(line.charAt(i + numberSize))) {
                    numberSize++;
                }
                bld.append(line.substring(i, i + numberSize) + " ");
                i = i + numberSize - 1;
            }
        }
        while(!stackArithmeticOperation.isEmpty()) {
            bld.append(stackArithmeticOperation.pop() + " ");
        }
        String resultLine = bld.toString();
        return resultLine;
    }

    private static boolean isSymbolNumber(char symbol) {
        return (symbol <= '9' && symbol >= '0');
    }

    private static boolean isSymbolOperation(char symbol) {
        return (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/');
    }

    private static int getOperationPriority(char typeOfOperation) {
        switch (typeOfOperation) {
            case '*':
            case '/': {
                return 2;
            }
            case '+':
            case '-': {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
}
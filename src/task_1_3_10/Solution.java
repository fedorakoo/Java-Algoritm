import java.util.Stack;

public class Solution
{
    public static String InfixToPostfix(String line) {
        Stack<Character> stackArithmeticOperation = new Stack<>();
        String resultLine = "";
        for(int i = 0; i < line.length(); i++) {
            if(isSymbolOperation(line.charAt(i))) {
                if(!stackArithmeticOperation.isEmpty() &&
                      getOperationPriority(line.charAt(i)) > getOperationPriority(stackArithmeticOperation.peek())) {
                    while(!stackArithmeticOperation.isEmpty() &&
                          getOperationPriority(line.charAt(i)) >= getOperationPriority(stackArithmeticOperation.peek())
                    && !stackArithmeticOperation.isEmpty()) {
                        resultLine += stackArithmeticOperation.pop();
                        resultLine += ' ';
                    }
                }
                stackArithmeticOperation.push(line.charAt(i));
            }
            else if(isSymbolNumber(line.charAt(i))) {
                int numberSize = 0;
                while(i + numberSize < line.length() && isSymbolNumber(line.charAt(i + numberSize))) {
                    numberSize++;
                }
                resultLine += line.substring(i, i + numberSize);
                resultLine += ' ';
                i += numberSize - 1;
            }
        }
        while(!stackArithmeticOperation.isEmpty()) {
            resultLine += stackArithmeticOperation.pop();
            resultLine += ' ';
        }
        return resultLine;
    }

    private static boolean isSymbolNumber(char symbol) {
        if(symbol <= '9' && symbol >= '0') {
            return true;
        }
        return false;
    }

    private static boolean isSymbolOperation(char symbol) {
        if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
            return true;
        }
        return false;
    }

    private static int getOperationPriority(char typeOfOperation) {
        if(isSymbolOperation(typeOfOperation) == false) {
            return 0;
        }
        if(typeOfOperation == '+' || typeOfOperation == '-') {
            return 1;
        }
        return 2;
    }
};
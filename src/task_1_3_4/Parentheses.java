package task_1_3_4;

import java.util.Stack;

public class Parentheses
{
    public static boolean isBracketsCorrect(String lineCheck) {
        Stack<Character> stackBrackets = new Stack<>();
        for(int i = 0; i < lineCheck.length(); i++) {
            if(lineCheck.charAt(i) == '(' ||
                    lineCheck.charAt(i) == '[' ||
                    lineCheck.charAt(i) == '{')
            {
                stackBrackets.push(lineCheck.charAt(i));
            }
            else if(stackBrackets.isEmpty()) {
                return false;
            }
            else {
                switch (lineCheck.charAt(i)) {
                    case (')') : {
                        if(stackBrackets.pop() != '(') {
                            return false;
                        }
                        break;
                    }
                    case('}') : {
                        if(stackBrackets.pop() != '{') {
                            return false;
                        }
                        break;
                    }
                    case (']') : {
                        if(stackBrackets.pop() != '[') {
                            return false;
                        }
                        break;
                    }
                };
            }
        }
        return true;
    }
}

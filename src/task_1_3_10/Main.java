package org.task_1_3_10;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main
{
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        String inputLine = in.nextLine();
        logger.info(solution.infixToPostfix(inputLine));
    }
}
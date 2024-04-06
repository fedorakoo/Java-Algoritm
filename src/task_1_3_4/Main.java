package task_1_3_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(Parentheses.isBracketsCorrect(line));
    }
}
package regular_expressions.task_5_4_17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Условие задания: Добавьте в класс NFA обработку обобщенных символов.");
        System.out.print("Введите значение регулярного выражения: ");
        String regexp = in.nextLine();
        NFA nfa = new NFA(regexp);
        System.out.print("Введите значение строки, необходимой для распознавания выражения: ");
        String line = in.nextLine();
        boolean result = nfa.recognizes(line);
        if (result) {
            System.out.println("Введенная строка соответствует введенному NFA");
        } else {
            System.out.println("Введенная строка не соответствует введенному NFA");
        }
        System.out.println("Спасибо за внимание!");
    }
}

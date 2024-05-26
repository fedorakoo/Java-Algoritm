package regular_expressions.task_5_4_21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            System.out.println("Условие задания: Добавьте в класс NFA обработку описателей дополнений.");
        System.out.print("Введите значение регулярного выражения: ");
        String regexp = in.nextLine();
        NFA nfa = new NFA(regexp);
        System.out.print("Введите значение строки, необходимой для распознавания выражения: ");
        String line = in.nextLine();
        boolean accepts = nfa.recognizes(line);
        if(accepts) {
            System.out.println("Введенная строка соответствует введенному NFA");
        }
        else {
            System.out.println("Введенная строка не соответствует введенному NFA");
        }
        System.out.println("Спасибо за внимание!");
    }
}

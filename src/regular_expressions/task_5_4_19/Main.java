package regular_expressions.task_5_4_19;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static using_sorts.task_2_5_13.Input.inputInt;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Условие задания: Добавьте в класс NFA обработку описателей заданного множества.");
        System.out.print("Введите значение регулярного выражения: ");
        String regexp = in.nextLine();
        NFA nfa = new NFA(regexp);
        System.out.print("Введите значение количества элементов: ");
        int number = inputInt();
        Set<String> set = new HashSet<>();
        while(set.size() < number) {
            System.out.print("Введите элемент: ");
            String ch = in.next();
            set.add(ch);
        }
        boolean accepts = nfa.recognizesAnyFromSet(set);
        if(accepts) {
            System.out.println("NFA принимает по крайней мере один элемент из множества.");
        }
        else {
            System.out.println("NFA не принимает ни одного элемента из множества.");
        }
        System.out.println("Спасибо за внимание!");
    }
}

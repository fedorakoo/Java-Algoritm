package using_sorts.task_2_5_13;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите программу LPT.java, которая принимает из командной строки целое число М, читает из стандартного ввода имена заданий и времена их выполнения и выводит расписание назначения заданий процессорам, которое приблизительно минимизирует время завершения последнего задания с помощью правила “наибольшее время выполнения — сначала”.");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество заданий: ");
        int m = in.nextInt();
        Map<Double, String> unsortedMap = new HashMap<>();
        for(int i = 0; i < m; i++) {
            System.out.print("Введите наименование задания номер " + (i + 1) + ": ");
            String name = in.next();
            System.out.print("Введите значение времени(в часах) выполнения задания номер " + (i + 1) + ": ");
            double time = in.nextDouble();
            unsortedMap.put(time, name);
        }
        System.out.print("\nПорядок выполнения заданий\n" +
                LPT.orderOfExecution(unsortedMap));
    }
}

package using_sorts.task_2_5_13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static using_sorts.task_2_5_13.Input.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите программу LPT.java, которая принимает из командной строки целое число М, читает из стандартного ввода имена заданий и времена их выполнения и выводит расписание назначения заданий процессорам, которое приблизительно минимизирует время завершения последнего задания с помощью правила “наибольшее время выполнения — сначала”.");
        System.out.print("Введите количество заданий: ");
        int m = inputInt();
        Map<String, Double> unsortedMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            System.out.print("Введите наименование задания номер " + (i + 1) + ": ");
            String name = inputName(unsortedMap);
            System.out.print("Введите значение времени(в секундах) выполнения задания номер " + (i + 1) + ": ");
            double time = inputDouble();
            unsortedMap.put(name, time);
        }
        System.out.print("\nПорядок выполнения заданий\n" + LPT.orderOfExecution(unsortedMap));
    }
}

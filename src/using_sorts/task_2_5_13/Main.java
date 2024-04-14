package using_sorts.task_2_5_13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите программу LPT.java, которая принимает из командной строки целое число М, читает из стандартного ввода имена заданий и времена их выполнения и выводит расписание назначения заданий процессорам, которое приблизительно минимизирует время завершения последнего задания с помощью правила “наибольшее время выполнения — сначала”.");
        System.out.print("Введите количество заданий: ");
        int m = inputInt();
        Map<String, Double> unsortedMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            System.out.print("Введите наименование задания номер " + (i + 1) + ": ");
            String name = inputName(unsortedMap);
            System.out.print("Введите значение времени(в часах) выполнения задания номер " + (i + 1) + ": ");
            double time = inputDouble();
            unsortedMap.put(name, time);
        }
        System.out.print("\nПорядок выполнения заданий\n" + LPT.orderOfExecution(unsortedMap));
    }
    private static String inputName(Map<String, Double> map) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        while (isRepeat(name, map)) {
            System.out.println(name);
            System.out.print("Введите корректное значение имени повторно: ");
            name = in.nextLine();
        }
        return name;
    }
    private static boolean isRepeat(String name, Map<String, Double> map) {
        Set<String> keys = map.keySet();
        for(String key : keys) {
            if(name.equals(key)) {
                return true;
            }
        }
        return false;
    }
    private static int inputInt() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumberInteger(number) || Integer.parseInt(number) < 0) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }
    private static boolean isNumberInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static double inputDouble() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumberDouble(number) || Double.parseDouble(number) <= 0) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Double.parseDouble(number);
    }
    private static boolean isNumberDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

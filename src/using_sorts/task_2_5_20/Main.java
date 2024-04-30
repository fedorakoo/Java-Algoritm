package using_sorts.task_2_5_20;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Пусть компьютер с параллельным процессором выполняет M заданий. Напишите программу, которая по заданным моментам запуска и завершения заданий находит максимальный интервал, когда процессор находился в состоянии простоя, и максимальный интервал, когда процессор находился в cостоянии работы.");
        LinkedList<String> jobOperationStart = new LinkedList<>();
        LinkedList<String> jobOperationEnd = new LinkedList<>();
        System.out.print("Введите значение количества операций: ");
        int n = inputInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите время начала операции номер " + (i + 1) + ": ");
            jobOperationStart.add(inputFirstTime());
            System.out.print("Введите время окончания операции номер " + (i + 1) + ": ");
            jobOperationEnd.add(inputSecondTime(jobOperationStart.get(i)));// Корректный пример ввода времени: 12:22
        }
        System.out.println(SortTime.getTimeIntervals(jobOperationStart, jobOperationEnd));
    }

    private static String inputSecondTime(String startTime) {
        Scanner in = new Scanner(System.in);
        String time;
        time = in.nextLine();
        while (!isLineCorrect(time)|| SortTime.countSecond(startTime) > SortTime.countSecond(time)) {
            outputIncorrectInput();
            time = in.nextLine();
        }
        return time;
    }
    private static String inputFirstTime() {
        Scanner in = new Scanner(System.in);
        String time;
        time = in.nextLine();
        while (!isLineCorrect(time)) {
            outputIncorrectInput();
            time = in.nextLine();
        }
        return time;
    }
    
    private static void outputIncorrectInput() {
        System.out.print("Введите корректное значение повторно: ");
    }

    private static int inputInt() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumber(number) || Integer.parseInt(number) <= 0) {
            outputIncorrectInput();
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isLineCorrect(String line) {
        if (line.length() != 8) {
            return false;
        } else {
            for (int i = 0; i < line.length(); i++) {
                if (i != 2 && i != 5 && !Character.isDigit(line.charAt(i)) 
                        || (i == 2 && line.charAt(i) != ':') || (i == 5 && line.charAt(i) != ':')) {
                    return false;
                }
            }
            int hour = Integer.parseInt(line.substring(0, 2));
            int minute = Integer.parseInt(line.substring(3, 5));
            int second = Integer.parseInt(line.substring(6, 8));
            return (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && second >= 0 && second < 60);
        }
    }
}
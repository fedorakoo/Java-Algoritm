package using_sorts.task_2_5_20;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Пусть компьютер с параллельным процессором выполняет M заданий. Напишите программу, которая по заданным моментам запуска и завершения заданий находит максимальный интервал, когда процессор находился в состоянии простоя, и максимальный интервал, когда процессор находился в cостоянии работы.");
        LinkedList<String> jobOperation = new LinkedList<>();
        System.out.print("Введите значение количества операций: ");
        int n = inputInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите время произведения операции над компьютером номер " + (i + 1) + ": ");
            jobOperation.add(inputTime()); // Корректный пример ввода времени: 12:22
        }
        System.out.println(SortTime.getTimeIntervals(jobOperation));
    }

    private static String inputTime() {
        Scanner in = new Scanner(System.in);
        String time;
        time = in.nextLine();
        while (!isLineCorrect(time)) {
            System.out.print("Введите корректное значение повторно: ");
            time = in.nextLine();
        }
        return time;
    }

    private static int inputInt() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumber(number) || Integer.parseInt(number) <= 0 || Integer.parseInt(number) % 2 == 1) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isLineCorrect(String line) {
        if (line.length() != 5) {
            return false;
        } else {
            for (int i = 0; i < line.length(); i++) {
                if (i != 2 && !Character.isDigit(line.charAt(i)) || (i == 2 && line.charAt(i) != ':')) {
                    return false;
                }
            }
            int hour = Integer.parseInt(line.substring(0, 2));
            int minute = Integer.parseInt(line.substring(3, 5));
            return (hour >= 0 && hour < 24 && minute >= 0 && minute < 60);
        }
    }
}
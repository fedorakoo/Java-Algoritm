package using_sorts.task_2_5_13;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Input {
    private Input() {
        
    }
    public static String inputName(Map<String, Double> map) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        while (isRepeat(name, map)) {
            System.out.println(name);
            System.out.print("Введите корректное значение имени повторно: ");
            name = in.nextLine();
        }
        return name;
    }
    public static boolean isRepeat(String name, Map<String, Double> map) {
        Set<String> keys = map.keySet();
        for(String key : keys) {
            if(name.equals(key)) {
                return true;
            }
        }
        return false;
    }
    public static int inputInt() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumberInteger(number) || Integer.parseInt(number) < 0) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Integer.parseInt(number);
    }
    public static boolean isNumberInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static double inputDouble() {
        Scanner in = new Scanner(System.in);
        String number;
        number = in.nextLine();
        while (!isNumberDouble(number) || Double.parseDouble(number) <= 0) {
            System.out.print("Введите корректное значение повторно: ");
            number = in.nextLine();
        }
        return Double.parseDouble(number);
    }
    public static boolean isNumberDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }  
}
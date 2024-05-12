package hash_table.task_3_4_39;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Напишите программу, которая вставляет N/2 случайных ключей типа int в таблицу размером N с линейным отговорением, а затем вычисляет среднюю стоимость промахов в полученной таблице в зависимости от длин кластеров, для N = 10^3, 10^4, 10^5 и 10^6.");
        int[] arrSize = {1000, 10000, 100000, 1000000};
        for (int size : arrSize) {
            String formattedDouble = new DecimalFormat("#0.0000").format(RandomAnalysis.calculateMisses(size));
            System.out.println("Для N = " + size + ", средняя стоимость промахов составляет " + formattedDouble);
        }
    }
}


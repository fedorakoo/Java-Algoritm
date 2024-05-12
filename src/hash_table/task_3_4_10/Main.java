package hash_table.task_3_4_10;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: Вставьте ключ E A S Y Q U T I O N в указанном порядке в первоначально пустую таблицу размером M = 5 с линейным опробованием. Для преобразования k-й буквы алфавита в индекс таблицы используйте хеш-функцию 11 * k % M. Выполните упражнение еще раз для M = 10.");
        String condition = "EASYQUTION";
        HashTable firstTable = new HashTable(5);
        HashTable secondTable = new HashTable(10);
        firstTable.add(condition);
        secondTable.add(condition);
        firstTable.print();
        secondTable.print();
    }
}

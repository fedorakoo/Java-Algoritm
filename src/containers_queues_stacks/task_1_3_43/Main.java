package containers_queues_stacks.task_1_3_43;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Условие задания: Напишите программу которая принимает из командной строки путь папки и выводит все файлы, содержащиеся в этой папке, причем содержимое каждой папки выводится рекурсивно под именем этой папки.\n" +
                "Введите путь к директории: ");
        String directoryPath = in.nextLine();
        File directoryFile = new File(directoryPath);
        if (Files.isDirectory(directoryFile.toPath().toRealPath())) {
            System.out.println(Directory.listContentDirectories(directoryFile, 0));
        } else {
            System.out.print("Ошибка");
        }
    }
}
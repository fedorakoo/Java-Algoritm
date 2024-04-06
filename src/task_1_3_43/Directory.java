package task_1_3_43;

import java.io.File;

public class Directory {
    public static String listContentDirectories(File directory, int recursionInput) {
        String directoryContents = "";
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                for(int i = 0; i < recursionInput; i++) {
                    directoryContents += "\t";
                }
                if (file.isFile()) {
                    directoryContents += ("Файл: " + file.getName() + "\n");
                }
                else {
                    directoryContents += ("Папка: " + file.getName() + "\n")
                            + listContentDirectories(file, (recursionInput + 1));
                }
            }
        }
        return directoryContents;
    }
}

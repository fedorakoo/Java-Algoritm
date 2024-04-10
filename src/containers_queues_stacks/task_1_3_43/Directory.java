package containers_queues_stacks.task_1_3_43;

import java.io.File;
import java.nio.file.*;

public class Directory {
    private Directory() {

    }

    public static String listContentDirectories(File directory, int recursionInput) {
        StringBuilder bld = new StringBuilder();

        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                for (int i = 0; i < recursionInput; i++) {
                    bld.append("\t");
                }
                if (Files.isSymbolicLink(file.toPath())) {
                    bld.append("Символическая ссылка: " + file.getName() + "\n");
                }
                if (file.isFile()) {
                    bld.append("Файл: " + file.getName() + "\n");
                } else {
                    bld.append("Папка: " + file.getName() + "\n" + listContentDirectories(file, (recursionInput + 1)));
                }
            }
        }
        return bld.toString();
    }
}
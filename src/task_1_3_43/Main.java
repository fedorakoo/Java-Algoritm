package task_1_3_43;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Directory directory = new Directory();
        String directoryPath = in.nextLine();
        File directoryFile = new File(directoryPath);
        System.out.println(directory.listContentDirectories(directoryFile, 0));
    }
}
package trie_tree.task_5_2_15;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Условие задания: ");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TST tree = new TST();
        tree.put(line);
        List<String> set = tree.getSubstrings();
        boolean isSuitable = true;
        int size = 1;
        while(isSuitable) {
            isSuitable = false;
            for (String number : set) {
                if(number.length() == size) {
                    isSuitable = true;
                    System.out.println(number);
                }
            }
            size++;
        }
    }
}

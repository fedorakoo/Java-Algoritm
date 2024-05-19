package hash_table.task_3_4_10;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    int size;
    List<List<Character>> table = new ArrayList<>();

    HashTable(int size) {
        this.size = size;
        for(int i = 0; i < size; i++) {
            table.add(new ArrayList<>());
        }
    }

    int getHash(char symbol) {
        return Math.abs(11 * symbol) % size;
    }

    void add(char symbol) {
        table.get(getHash(symbol)).add(symbol);
    }
    void add(String line) {
        for(char symbol : line.toCharArray()) {
            add(symbol);
        }
    }
    void print() {
        System.out.println("Хеш таблица [" + size + "]");
        for (int t = 0; t < table.size(); t++) {
            System.out.print("[" + (t + 1)+ "] ");
            for (int i = 0; i < table.get(t).size(); i++) {
                System.out.print((table.get(t).get(i)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
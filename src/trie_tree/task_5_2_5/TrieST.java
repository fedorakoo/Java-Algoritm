package trie_tree.task_5_2_5;

import java.util.HashMap;
import java.util.Map;

public class TrieST {
    class TrieNode {
        boolean isKey;
        Map<Character, TrieNode> children;
        char value;
        public TrieNode(Character value, boolean isKey) {
            this.isKey = isKey;
            children = new HashMap<>();
            this.value = value;
        }
    }

    private TrieNode root;
    private int number;

    TrieST() {
        root = new TrieNode('\0', false);
        number = 0;
    }

    public void add(String key) {
        TrieNode place = root;
        if (contains(key)) {
            System.out.println("Элемент с заданным ключем уже существует");
        } else {
            for (int i = 0; i < key.length(); i++) {
                boolean isWord = (i == key.length() - 1);
                place.children.putIfAbsent(Character.valueOf(key.charAt(i)), new TrieNode(Character.valueOf(key.charAt(i)), false));
                place = place.children.get(Character.valueOf(key.charAt(i)));
                if (isWord) {
                    if (!place.isKey) {
                        number++;
                        System.out.println("Элемент успешно добавлен");
                    }
                    place.isKey = true;
                }
            }
        }
    }

    public void delete(String key){
        TrieNode place = root;
        TrieNode nonEmptyNode = place;
        char nonEmptyChar = '\0';
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            if (place.children.containsKey(currentChar)) {
                nonEmptyNode = place;
                nonEmptyChar = currentChar;
                place = place.children.get(currentChar);
            }
            else {
                System.out.println("Элемент с заданным ключом не найден");
                return;
            }
        }
        place.isKey = false;
        if (place.children.isEmpty() && !place.isKey) {
            nonEmptyNode.children.remove(nonEmptyChar);
        }
        System.out.println("Элемент успешно удален");
        number--;
    }

    public boolean contains(String key) {
        TrieNode place = root;
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            if (!place.children.containsKey(currentChar)) {
                return false;
            }
            place = place.children.get(currentChar);
        }
        return place.isKey;
    }

    public boolean isEmpty() {
        return (number == 0);
    }

    public int countWords() {
        return number;
    }

    public String toString() {
        return toString(root, "");
    }

    private String toString(TrieNode node, String line)  {
        StringBuilder bld = new StringBuilder();
        if (node.isKey) {
            bld.append(line + " ");
        }
        for (Character letter : node.children.keySet()) {
            bld.append(toString(node.children.get(letter), line + letter));
        }
        return bld.toString();
    }
}

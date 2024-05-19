package trie_tree.task_5_2_6;

import java.util.HashMap;
import java.util.Map;

public class StringSET {
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
    StringSET() {
        root = new TrieNode('\0', false);
    }
    public void add(String key) {
        TrieNode place = root;
        if (contains(key)) {
            System.out.println("Элемент с заданным ключем уже существует");
        } else {
            for (int i = 0; i < key.length(); i++) {
                boolean isWord = (i == key.length() - 1);
                if (place.children.get(Character.valueOf(key.charAt(i))) == null) {
                    if (isWord) {
                        System.out.println("Элемент успешно добавлен");
                    }
                    place.children.put(Character.valueOf(key.charAt(i)), new TrieNode(Character.valueOf(key.charAt(i)), isWord));
                }
                place = place.children.get(Character.valueOf(key.charAt(i)));
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
                } else {
                    System.out.println("Элемент с заданным ключем не найден");
                    return;
                }
            }
            place.isKey = false;
            if (place.children.isEmpty() && !place.isKey) {
                nonEmptyNode.children.remove(nonEmptyChar);
            }
            System.out.println("Элемент успешно удален");
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
        return root.children.isEmpty();
    }
    public int size() {
        return countWords(root);
    }

    private int countWords(TrieNode node) {
        int result = 0;
        if (node.isKey) {
            result++;
        }
        for (Character letter : node.children.keySet()) {
            result += countWords(node.children.get(letter));
        }
        return result;
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
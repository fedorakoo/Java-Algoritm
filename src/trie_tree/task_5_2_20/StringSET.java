package trie_tree.task_5_2_20;

import java.util.HashMap;
import java.util.Map;

public class StringSET {
    class TrieNode {
        boolean isKey;
        Map<Character, StringSET.TrieNode> children;
        char value;
        public TrieNode(Character value, boolean isKey) {
            this.isKey = isKey;
            children = new HashMap<>();
            this.value = value;
        }
    }
    private TrieNode root;
    private int number;
    StringSET() {
        root = new StringSET.TrieNode('\0', false);
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
        StringSET.TrieNode place = root;
        StringSET.TrieNode nonEmptyNode = place;
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
        number--;
    }

    public boolean contains(String key) {
        StringSET.TrieNode place = root;
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
        return countWords(root);
    }
    private int countWords(StringSET.TrieNode node) {
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
    private String toString(StringSET.TrieNode node, String line)  {
        StringBuilder bld = new StringBuilder();
        if (node.isKey) {
            bld.append(line + " ");
        }
        for (Character letter : node.children.keySet()) {
            bld.append(toString(node.children.get(letter), line + letter));
        }
        return bld.toString();
    }
    public boolean countainPrefix(String key) {
        TrieNode place = root;
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            if(place.children.get(Character.valueOf(currentChar)) != null) {
                place = place.children.get(Character.valueOf(currentChar));
            }
            else return false;
        }
        return true;
    }
}
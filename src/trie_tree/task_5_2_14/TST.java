package trie_tree.task_5_2_14;

import java.util.TreeSet;
import java.util.Set;

public class TST {
    public TST() {
        // obviously empty constructor for fixing errors
    }
    private Node root;
    private class Node {
        char symbol;
        Node left;
        Node mid;
        Node right;
        boolean isWord;
    }

    public void put(String key) {
        root = put(root, key, 0);
    }

    private Node put(Node node, String key, int number) {
        char symbol = key.charAt(number);
        if (node == null) {
            node = new Node();
            node.symbol = symbol;
        }
        if (symbol < node.symbol) {
            node.left = put(node.left, key, number);
        } else if (symbol > node.symbol) {
            node.right = put(node.right, key, number);
        } else if (number < key.length() - 1) {
            node.mid = put(node.mid, key, number + 1);
        } else {
            node.isWord = true;
        }
        return node;
    }
    Set<String> getSubstrings() {
        Set<String> myTreeSet = new TreeSet<>();
        Node temp = root;
        myTreeSet.addAll(getSubstrings(temp, ""));
        while(temp != null){
            temp = temp.left;
            myTreeSet.addAll(getSubstrings(temp, ""));
        }
        temp = root;
        while(temp.right != null) {
            temp = temp.right;
            myTreeSet.addAll(getSubstrings(temp, ""));
        }
        temp = root;
        while(temp.mid != null) {
            temp = temp.mid;
            myTreeSet.addAll(getSubstrings(temp, ""));
        }
        return myTreeSet;
    }
    Set<String> getSubstrings(Node node, String line) {
        Set<String> myTreeSet = new TreeSet<>();
        if(node != null) {
            line += node.symbol;
            if(!node.isWord) {
                myTreeSet.add(line);
            }
            myTreeSet.addAll(getSubstrings(node.left, line));
            myTreeSet.addAll(getSubstrings(node.right, line));
            myTreeSet.addAll(getSubstrings(node.mid, line));
        }
        return myTreeSet;
    }
}

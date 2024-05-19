package trie_tree.task_5_2_5;

public class TST {
    private TST.Node root;
    private class Node {
        char symbol;
        TST.Node left;
        TST.Node mid;
        TST.Node right;
        boolean isWord;
    }

    public void add(String key) {
        root = add(root, key, 0);
    }

    private TST.Node add(TST.Node node, String key, int number) {
        char symbol = key.charAt(number);
        if (node == null) {
            node = new TST.Node();
            node.symbol = symbol;
        }
        if (symbol < node.symbol) {
            node.left = add(node.left, key, number);
        }
        else if (symbol > node.symbol) {
            node.right = add(node.right, key, number);
        }
        else if (number < key.length() - 1) {
            node.mid = add(node.mid, key, number + 1);
        }
        else if(node.isWord) {
            System.out.println("Элемент с данным ключом уже существует");
        }
        else {
            System.out.println("Элемент успешно добавлен");
            node.isWord = true;
        }
        return node;
    }
    public boolean isEmpty() {
        return (root == null);
    }

    public boolean contains(String key) {
        return contains(root, key, 0);
    }

    private boolean contains(Node node, String key, int number) {
        if (node == null) {
            return false;
        }
        char symbol = key.charAt(number);
        if (symbol < node.symbol) {
            return contains(node.left, key, number);
        }
        else if (symbol > node.symbol) {
            return contains(node.right, key, number);
        }
        else if (number < key.length() - 1) {
            return contains(node.mid, key, number + 1);
        }
        else {
            return node.isWord;
        }
    }

    public void delete(String key) {
        if(contains(key)) {
            root = delete(root, key, 0);
            System.out.println("Элемент успешно удален");
        }
        else {
            System.out.println("Элемент с заданным ключом не найден");
        }
    }

    private Node delete(Node node, String key, int number) {
        if (node == null) {
            return null;
        }
        char symbol = key.charAt(number);
        if (symbol < node.symbol) {
            node.left = delete(node.left, key, number);
        }
        else if (symbol > node.symbol) {
            node.right = delete(node.right, key, number);
        }
        else if (number < key.length() - 1) {
            node.mid = delete(node.mid, key, number + 1);
        }
        else {
            node.isWord = false;
        }
        if (!node.isWord && node.left == null && node.mid == null && node.right == null) {
            return null;
        }
        return node;
    }

    public String toString() {
        return toString(root, "");
    }
    private String toString(Node node, String line)  {
        StringBuilder bld = new StringBuilder();
        if(node != null) {
            if (node.isWord) {
                bld.append(line + " ");
            }
            if (node.left != null)
                bld.append(toString(node.left, line + node.left.symbol));
            if (node.mid != null)
                bld.append(toString(node.mid, line + node.mid.symbol));
            if (node.right != null)
                bld.append(toString(node.right, line + node.right.symbol));
        }
        return bld.toString();
    }
}

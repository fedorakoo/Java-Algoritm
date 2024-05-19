package balanced_search_tree.task_3_3_42;

import java.util.*;

public class RedBlackTree {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int value;
        Node left;
        Node right;
        boolean color;

        Node(int val, boolean color) {
            this.value = val;
            this.color = color;
        }
    }
    public Node getRoot() {
        return root;
    }
    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(int val) {
        root = put(root, val);
        root.color = BLACK;
    }

    private Node put(Node h, int val) {
        if (h == null) {
            return new Node(val, RED);
        }
        int cmp = val;
        if (cmp < 0) {
            h.left = put(h.left, val);
        } else if (cmp > 0) {
            h.right = put(h.right, val);
        } else {
            h.value = val;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }
    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    List<Integer> getListElement(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null)
            return res;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            res.add(tempNode.value);
            if (tempNode.left != null && tempNode.left.value != -1) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null && tempNode.right.value != -1) {
                queue.add(tempNode.right);
            }
        }
        return res;
    }

    double getPercentageRedElementsRedBlackTree(Node node) {
        Pair number = getNumberDifferentColor(node);
        if(number.sum() == 0) {
            return 0;
        }
        else {
            return ((double)number.first() / (double)number.sum()) * 100;
        }
    }
    Pair getNumberDifferentColor(Node node) {
        Pair number = new Pair(0,0);
        if(node == null) {
            return number;
        }
        else {
            number.addNumber(getPairNumberColor(node));
            if(node.left != null) {
                number.addNumber(getNumberDifferentColor(node.left));
            }
            if(node.right != null) {
                number.addNumber(getNumberDifferentColor(node.right));
            }
        }
        return number;
    }
    Pair getPairNumberColor(Node node) {
        if(node.color == RED) {
            return new Pair(1,0);
        }
        else {
            return new Pair(0,1);
        }
    }
}

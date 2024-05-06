package balanced_search_tree.task_3_3_22;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RedBlackTree {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {
        int value;
        Node left;
        Node right;
        boolean color;
        boolean isRed() {
            return (color == RED);
        }
        boolean isBlack() {
            return (color == BLACK);
        }

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
    public static void printTree(Node node) {
        System.out.println("Бинарное дерево поиска");
        Deque<Node> globalStack = new LinkedList<>();
        globalStack.push(node);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (!isRowEmpty) { Deque<Node> localStack = new LinkedList<>();
            isRowEmpty = true;
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty())
            {
                Node temp = globalStack.pop();
                if (temp != null) {
                    if(temp.value != -1) {
                        System.out.print(temp.value);
                    }
                    else {
                        System.out.print("__");
                    }
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
    Node select(Node node, int value) {
        if(node == null) {
            System.out.println("Элемент не найден");
            return null;
        }
        if(node.value == value) {
            return node;
        }
        return (node.value > value) ? select(node.left, value) : select(node.right, value);
    }
    Node min(Node node) {
        if(node == null) {
            return null;
        }
        else if(node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }
    Node max(Node node) {
        if(node == null) {
            return null;
        }
        else if(node.right == null) {
            return node;
        }
        else {
            return max(node.right);
        }
    }
    int rank(Node node, int value) {
        if (node == null) {
            return 0;
        }
        if (node.value == value) {
            return 1 + size(node.left);
        }
        else if(node.value < value) {
            return 1 + size(node.left) + rank(node.right, value);
        }
        else {
            return rank(node.left, value);
        }
    }
    int size(Node node) {
        if(node == null) {
            return 0;
        }
        else  {
            return 1 + size(node.left) + size(node.right);
        }
    }
    int height(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    int floor(Node node, int value) {
        if (node == null)
            return -1;
        if (node.value == value) {
            return node.value;
        }
        if (node.value > value) {
            return floor(node.left, value);
        }
        int fl = floor(node.right, value);
        return (fl <= value && fl != -1) ? fl : node.value;
    }
    int ceiling(Node node, int value)
    {
        if (node == null) {
            return -1;
        }
        if (node.value == value) {
            return node.value;
        }
        else if (node.value < value) {
            return ceiling(node.right, value);
        }
        int ceil = ceiling(node.left, value);
        return (ceil >= value) ? ceil : node.value;
    }
    List<Integer> values(Node node, int leftLimit, int rightLimit) {
        List<Integer> queue = new LinkedList<>();
        if (node == null) {
            return queue;
        }
        if (node.value >= leftLimit && node.value <= rightLimit) {
            queue.add(node.value);
            queue.addAll(values(node.left, leftLimit, rightLimit));
            queue.addAll(values(node.right, leftLimit, rightLimit));
        } else if (node.value < leftLimit) {
            queue.addAll(values(node.right, leftLimit, rightLimit));
        } else if (node.value > rightLimit) {
            queue.addAll(values(node.left, leftLimit, rightLimit));
        }
        return queue;
    }
}

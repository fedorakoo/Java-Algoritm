package binary_search_tree.task_3_2_29;

import java.util.Deque;
import java.util.LinkedList;

class BinarySearchTree {
    BinarySearchTree() {

    }

    class Node {
        Node left = null;
        Node right = null;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        else if (key < node.key) {
            node.left = insert(node.left, key);
        }
        else {
            node.right = insert(node.right, key);
        }
        return node;
    }
    Node delete(Node node, int key) {
        if (node == null) {
            System.out.println("Элемент не найден");
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            System.out.println("Элемент успешно удален");
            if (node.left == null || node.right == null) {
                node = (node.left == null ? node.right : node.left);
            } else {
                Node newNode = min(node.right);
                if(newNode != null)
                    node.key = newNode.key;
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }

    static Node min(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }
    int height(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    static boolean isCorrectBinarySearchTree(Node node, int leftValue, int rightValue) {
        if (node == null)
            return true;

        if (node.key < leftValue || node.key > rightValue)
            return false;

        return (isCorrectBinarySearchTree(node.left, leftValue, node.key-1) &&
                isCorrectBinarySearchTree(node.right, node.key+1, rightValue));
    }
    public static void printTree(Node node) {
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
                    System.out.print(temp.key);
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
    static Node max(Node node) {
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
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    private Node parent;
}

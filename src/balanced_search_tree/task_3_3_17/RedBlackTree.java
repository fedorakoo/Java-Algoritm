package balanced_search_tree.task_3_3_17;

import java.util.Deque;
import java.util.LinkedList;

public class RedBlackTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    public static final Node nil = new Node(-1);
    private Node root = nil;

    public Node getParent() {
        return root;
    }
    public void setParent(Node node) {
        this.root = node;
    }
    public static class Node {
        int key;
        boolean color = BLACK;
        Node left = nil;
        Node right = nil;
        Node parent = nil;
        boolean isRed() {
            return !color;
        }
        boolean isBlack() {
            return color;
        }
        Node(int key){
            this.key = key;
        }
    }
    public void insert(int key) {
        Node node = new Node(key);
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            updateInsertNode(node, temp);
            fixTree(node);
        }
    }
    void updateInsertNode(Node node, Node temp) {
        node.color = RED;
        boolean isDuty = true;
        while (isDuty) {
            if (node.key < temp.key) {
                if (temp.left == nil) {
                    temp.left = node;
                    node.parent = temp;
                    isDuty = false;
                }
                else {
                    temp = temp.left;
                }
            } else  {
                if (temp.right == nil) {
                    temp.right = node;
                    node.parent = temp;
                    isDuty = false;
                }
                else {
                    temp = temp.right;
                }
            }
        }
    }
    public void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;
                boolean boolExpression = true;
                if (firstCheckUncle(uncle)) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    boolExpression = false;
                } else if (node == node.parent.right) {
                    node = node.parent;
                    rotateLeft(node);
                }
                node = fixRotateRight(boolExpression, node);
            } else if(node.parent.parent.left != null) {
                uncle = node.parent.parent.left;
                boolean boolExpression = true;
                if (firstCheckUncle(uncle)) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    boolExpression = false;
                }
                if (node == node.parent.left) {
                    node = node.parent;
                    rotateRight(node);
                }
                node = fixRotateLeft(boolExpression, node);
            }
            else return;
        }
        root.color = BLACK;
    }

    boolean firstCheckUncle(Node uncle) {
        return uncle != nil && uncle.color == RED;
    }

    Node fixRotateLeft(boolean boolExpression, Node node) {
        if (boolExpression) {
            node.parent.color = BLACK;
            node.parent.parent.color = RED;
            rotateLeft(node.parent.parent);
        }
        return node;
    }

    Node fixRotateRight(boolean boolExpression, Node node) {
        if (boolExpression) {
            node.parent.color = BLACK;
            node.parent.parent.color = RED;
            rotateRight(node.parent.parent);
        }
        return node;
    }
    void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != nil) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == nil) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != nil) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == nil) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }
    public static void printTree(Node node) {
        System.out.println("Красно-черное бинарное дерево поиска");
        Deque<Node> globalStack = new LinkedList<>();
        globalStack.push(node);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (!isRowEmpty) {
            Deque<Node> localStack = new LinkedList<>();
            isRowEmpty = true;
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    if (temp.key == -1) {
                        System.out.print("__");
                    } else {
                        System.out.print(temp.key);
                    }
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    isRowEmpty = !(temp.left != null || temp.right != null);
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
}

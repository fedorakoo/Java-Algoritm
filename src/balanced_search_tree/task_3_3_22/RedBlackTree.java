package balanced_search_tree.task_3_3_22;

import balanced_search_tree.task_3_3_42.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
                    if(temp.key != -1) {
                        System.out.print(temp.key);
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
        if(node == nil) {
            return number;
        }
        else {
            number.addNumber(getPairNumberColor(node));
            if(node.left != nil) {
                number.addNumber(getNumberDifferentColor(node.left));
            }
            if(node.right != nil) {
                number.addNumber(getNumberDifferentColor(node.right));
            }
        }
        return number;
    }
    Pair getPairNumberColor(Node node) {
        if(node.isRed()) {
            return new Pair(1,0);
        }
        else {
            return new Pair(0,1);
        }
    }
    Node select(Node node, int key) {
        if(node == nil) {
            System.out.println("Элемент не найден");
            return nil;
        }
        if(node.key == key) {
            return node;
        }
        return (node.key > key) ? select(node.left, key) : select(node.right, key);
    }
    Node min(Node node) {
        if(node == nil) {
            return nil;
        }
        else if(node.left == nil) {
            return node;
        }
        else {
            return min(node.left);
        }
    }
    Node max(Node node) {
        if(node == nil) {
            return nil;
        }
        else if(node.right == nil) {
            return node;
        }
        else {
            return max(node.right);
        }
    }
    int rank(Node node, int key) {
        if (node == nil) {
            return 0;
        }
        if (node.key == key) {
            return 1 + size(node.left);
        }
        else if(node.key < key) {
            return 1 + size(node.left) + rank(node.right, key);
        }
        else {
            return rank(node.left, key);
        }
    }
    int size(Node node) {
        if(node == nil) {
            return 0;
        }
        else  {
            return 1 + size(node.left) + size(node.right);
        }
    }
    int height(Node node) {
        if(node == nil) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    int floor(Node node, int key) {
        if (node == nil)
            return -1;
        if (node.key == key) {
            return node.key;
        }
        if (node.key > key) {
            return floor(node.left, key);
        }
        int fl = floor(node.right, key);
        return (fl <= key && fl != -1) ? fl : node.key;
    }
    int ceiling(Node node, int key)
    {
        if (node == nil) {
            return -1;
        }
        if (node.key == key) {
            return node.key;
        }
        else if (node.key < key) {
            return ceiling(node.right, key);
        }
        int ceil = ceiling(node.left, key);
        return (ceil >= key) ? ceil : node.key;
    }
    List<Integer> keys(Node node, int leftLimit, int rightLimit) {
        List<Integer> queue = new LinkedList<>();
        if (node == nil) {
            return queue;
        }
        if (node.key >= leftLimit && node.key <= rightLimit) {
            queue.add(node.key);
            queue.addAll(keys(node.left, leftLimit, rightLimit));
            queue.addAll(keys(node.right, leftLimit, rightLimit));
        } else if (node.key < leftLimit) {
            queue.addAll(keys(node.right, leftLimit, rightLimit));
        } else if (node.key > rightLimit) {
            queue.addAll(keys(node.left, leftLimit, rightLimit));
        }
        return queue;
    }
}

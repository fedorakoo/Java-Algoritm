package binary_search_tree.task_3_2_6;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {
    BinarySearchTree() 
    {
        
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
        if (node == null)
        { 
            fastHeight = 1;
            return new Node(key);
        } 
        else if (key == node.key)
        { 
            System.out.println("Узел с ключом " + key + " уже существует");
            return node; 
        }
        else if (key < node.key) {
            node.left = insert(node.left, key);
        }
        else { 
            node.right = insert(node.right, key);
        } 
        
        fastHeight = Math.max(height(node.left), height(node.right)) + 1;
        return node;
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
    Node delete(Node node, int key) {
        if(node == null) {
            System.out.println("Элемент не найден");
            return null;
        }
        else if(key < node.key) {
            node.left = delete(node.left, key);
        }
        else if(key > node.key) {
            node.right = delete(node.right, key);
        }
        else {
            System.out.println("Элемент успешно удален");
            if(node.left == null || node.right == null) {
                node = (node.left == null ? node.right : node.left);
            }
            else {
                Node newNode = min(node.right);
                node.key = newNode.key;
                node.right = delete(node.right, node.key);
            }
        }
        fastHeight = height(node);
        return node;
    }
    int height(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public static void printTree(Node node) {
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
                    System.out.print(temp.key);
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
    Node getParent() {
        return parent;
    }
    void setParent(Node node) {
        parent = node;
    }
    int getFastHeight() {
        return fastHeight;
    }
    private Node parent;
    private int fastHeight;
}

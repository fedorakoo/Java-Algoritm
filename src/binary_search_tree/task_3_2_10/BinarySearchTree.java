package binary_search_tree.task_3_2_10;

import java.util.*;
import java.util.List;

class BinarySearchTree {
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
        if(node == null) {
            node = new Node(key);
        }
        else if (key < node.key) {
            if(node.left == null) {
                node.left = new Node(key);
            }
            else {
                insert(node.left, key);
            }
        }
        else {
            if(node.right == null) {
                node.right = new Node(key);
            }
            else {
                insert(node.right, key);
            }
        }
        return node;
    }
    Node select(Node node, int key) {
        if(node == null) {
            return null;
        }
        if(node.key == key) {
            return node;
        }
        return (node.key < key) ? select(node.left, key) : select(node.right, key);
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
    int rank(Node node, int key) {
        if (node == null) {
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
    void deleteMin() {
        parent = delete(parent, min(parent).key);
    }
    void deleteMax() {
        parent = delete(parent, max(parent).key);
    }
    List<Integer> keys(Node node, int leftLimit, int rightLimit) {
        List<Integer> queue = new LinkedList<>();
        if (node == null) {
            return queue;
        }
        if(node.key >= leftLimit && node.key <= rightLimit) {
            queue.add(node.key);
            List<Integer> queueLeft = keys(node.left, leftLimit, rightLimit);
            List<Integer> queueRight = keys(node.right, leftLimit, rightLimit);
            for(int i = 0; i < queueLeft.size(); i++) {
                queue.add(queueLeft.get(i));
            }
            for(int i = 0; i < queueRight.size(); i++) {
                queue.add(queueRight.get(i));
            }
        }
        else if(node.key > rightLimit) {
            return keys(node.right, leftLimit, rightLimit);
        }
        return keys(node.left, leftLimit, rightLimit);
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
    Node delete(Node node, int key) {
        if(node == null) {
            return null;
        }
        else if(key < node.key) {
            node.left = delete(node.left, key);
        }
        else if(key > node.key) {
            node.right = delete(node.right, key);
        }
        else {
            if(node.left == null || node.right == null) {
                node = (node.left == null ? node.right : node.left);
            }
            else {
                Node newNode = min(node.right);
                node.key = newNode.key;
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }
    Node floor(Node node, int key) {
        if(node == null) {
            return null;
        }
        else if(key == node.key) {
            return node;
        }
        else if(key < node.key) {
            if(node.left == null) {
                return node;
            }
            else {
                return floor(node.left, key);
            }
        }
        else {
            if(node.right == null) {
                return node;
            }
            else {
                return floor(node.right, key);
            }
        }
    }
    Node ceiling(Node node, int key) {
        if(node == null) {
            return null;
        }
        else if(key == node.key) {
            return node;
        }
        else if(key > node.key) {
            if(node.left == null) {
                return node;
            }
            else {
                return floor(node.left, key);
            }
        }
        else {
            if(node.right == null) {
                return node;
            }
            else {
                return floor(node.right, key);
            }
        }
    }
    int height(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    int size(Node node) {
        if(node == null) {
            return 0;
        }
        else  {
            return 1 + size(node.left) + size(node.right);
        }
    }
    void printTree(Node node) {
        if(node == null) return;
        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }
    public Node parent;
   
}

package binary_search_tree.task_3_2_21;

import java.security.SecureRandom;
import java.util.Random;

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
    private void resetvisitedNodeCount() {
        size = Math.max(size, visitedNodeCount + 1);
        visitedNodeCount = 1;
    }
    Node insert(Node node, int key) {
        if(node == null) {
            size = 1;
            node = new Node(key);
        }
        else if (key < node.key) {
            if(node.left == null) {
                resetvisitedNodeCount();
                node.left = new Node(key);
            }
            else {
                visitedNodeCount++;
                insert(node.left, key);
            }
        }
        else {
            if(node.right == null) {
                resetvisitedNodeCount();
                node.right = new Node(key);
            }
            else {
                visitedNodeCount++;
                insert(node.right, key);
            }
        }
        return node;
    }
    Node getMin(Node node) {
        if(node == null) {
            return null;
        }
        else if(node.left == null) {
            return node;
        }
        else {
            return getMin(node.left);
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
                Node newNode = getMin(node.right);
                node.key = newNode.key;
                node.right = delete(node.right, node.key);
            }
        }
        size = height(node);
        return node;
    }
    int height(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    void printTree(Node node) {
        if(node == null) return;
        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }
    static boolean isBinaryTree(Node node) {
        if(node == null) {
            return false;
        }
        else {
            if(node.left == null && node.right == null) {
                return true;
            }
            else if(node.left != null && node.right != null) {
                if(node.right.key < node.left.key) {
                    return false;
                }
                else return isBinaryTree(node.left) && isBinaryTree(node.right);
            }
            else {
                return isBinaryTree(node.left) || isBinaryTree(node.right);
            }
        }
    }
    int randomKey(Node node) {
        int height = size();
        int randHeight = random.nextInt(0,  height);
        for(int i = 0; i < randHeight; i++) {
            if(numberChilt(node) == 2) {
                int randChild = random.nextInt(1,  3);
                if(randChild == 1) {
                    node = node.left;
                }
                else {
                    node = node.right;
                }
            }
            else if(numberChilt(node) == 1) {
                node = (node.left == null ? node.right : node.left);
            }
            else return node.key;
        }
        return node.key;
    }
    int numberChilt(Node node) {
        if(node.left != null && node.right != null) {
            return 2;
        }
        else if(node.left != null || node.right != null) {
            return 1;
        }
        return 0;
    }
    int size() {
        return size;
    }
    Random random = new SecureRandom();
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    private Node parent;
    private int size;
    private int visitedNodeCount = 1;
}

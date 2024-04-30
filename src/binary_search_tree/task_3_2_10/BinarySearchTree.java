package binary_search_tree.task_3_2_10;

import java.util.*;

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
        if (node == null) {
            return new Node(key);
        } else if (key == node.key) {
            System.out.println("Узел с ключом " + key + " уже существует");
            return node;
        } else if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        return node;
    }
    Node select(Node node, int key) {
        if(node == null) {
            System.out.println("Элемент не найден");
            return null;
        }
        if(node.key == key) {
            return node;
        }
        return (node.key > key) ? select(node.left, key) : select(node.right, key);
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
        if(min(parent) == null) {
            System.out.println("Минимального элемента нет");
        }
        else {
            System.out.println("Минимальный элемент: " + max(parent).key);
            parent = delete(parent, min(parent).key);
        }
    }
    void deleteMax() {
        if(max(parent) == null) {
            System.out.println("Максимального элемента нет");
        }
        else {
            System.out.println("Максимальный элемент: " + max(parent).key);
            parent = delete(parent, max(parent).key);
        }
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
            return queue;
        }
        else if(node.key > rightLimit) {
            keys(node.left, leftLimit, rightLimit);
        }
        return keys(node.right, leftLimit, rightLimit);
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
        return node;
    }
   
    int floor(Node node, int key) {
        if (node == null)
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
        if (node == null) {
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
    public static void printTree(Node node) {
        Stack globalStack = new Stack();
        globalStack.push(node);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (!isRowEmpty) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Node temp = (Node)globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.key);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
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
    void setParent(Node parent) {
        this.parent = parent;
    }
    Node getParent() {
        return parent;
    }
    private Node parent;
}

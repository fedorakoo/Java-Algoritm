package binary_search_tree.task_3_2_6;

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
    Node getParent() {
        return parent;
    }
    void setParent(Node node) {
        parent = node;
    }
    int size() {
        return size;
    }
    private Node parent;
    private int size;
    private int visitedNodeCount = 1;
}

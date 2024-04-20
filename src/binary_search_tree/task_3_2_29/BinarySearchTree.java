package binary_search_tree.task_3_2_29;

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
    Node search(Node node, int key) {
        if(node == null) {
            return null;
        }
        if(node.key == key) {
            return node;
        }
        return (node.key < key) ? search(node.left, key) : search(node.right, key);
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
    Node getMax(Node node) {
        if(node == null) {
            return null;
        }
        else if(node.right == null) {
            return node;
        }
        else {
            return getMax(node.right);
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
        return node;
    }
    int height(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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
    void printTree(Node node) {
        if(node == null) return;
        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    private Node parent;
}

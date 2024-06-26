package balanced_search_tree.task_3_3_11;

import java.util.Deque;
import java.util.LinkedList;

public class RedBlackTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private final Node nil = new Node(-1);
    private Node parent = nil;

    public Node getParent() {
        return parent;
    }

    public class Node {
        int key;
        boolean color = BLACK;
        Node left = nil;
        Node right = nil;
        Node parent = nil;

        Node(int key) {
            this.key = key;
        }
    }

    public void insert(int key) {
        Node node = new Node(key);
        Node temp = parent;
        if (parent == nil) {
            parent = node;
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
                boolean boolChangesNeed = true;
                if (firstCheckUncle(uncle)) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    boolChangesNeed = false;
                } else if (node == node.parent.right) {
                    node = node.parent;
                    rotateLeft(node);
                }
                node = fixRotateRight(boolChangesNeed, node);
            } else {
                uncle = node.parent.parent.left;
                boolean boolChangesNeed = true;
                if (firstCheckUncle(uncle)) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    boolChangesNeed = false;
                }
                if (node == node.parent.left) {
                    node = node.parent;
                    rotateRight(node);
                }
                node = fixRotateLeft(boolChangesNeed, node);
            }
        }
        parent.color = BLACK;
    }

    boolean firstCheckUncle(Node uncle) {
        return uncle != nil && uncle.color == RED;
    }

    Node fixRotateLeft(boolean boolChangesNeed, Node node) {
        if (boolChangesNeed) {
            node.parent.color = BLACK;
            node.parent.parent.color = RED;
            rotateLeft(node.parent.parent);
        }
        return node;
    }

    Node fixRotateRight(boolean boolChangesNeed, Node node) {
        if (boolChangesNeed) {
            node.parent.color = BLACK;
            node.parent.parent.color = RED;
            rotateRight(node.parent.parent);
        }
        return node;
    }

    void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {
            Node right = parent.right;
            parent.right = right.left;
            right.left.parent = parent;
            parent.parent = right;
            right.left = parent;
            right.parent = nil;
            parent = right;
        }
    }

    void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {
            Node left = parent.left;
            parent.left = parent.left.right;
            left.right.parent = parent;
            parent.parent = left;
            left.right = parent;
            left.parent = nil;
            parent = left;
        }
    }

    public static void printTree(Node node) {
        Deque<RedBlackTree.Node> globalStack = new LinkedList<>();
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
                        char symbol = (char) (temp.key);
                        System.out.print(symbol);
                    }
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    isRowEmpty = isChildNull(temp);
                } else {
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
    static boolean isChildNull(Node temp) {
        return !(temp.left != null || temp.right != null);
    }
}
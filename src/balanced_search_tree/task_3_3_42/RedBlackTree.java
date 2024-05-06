package balanced_search_tree.task_3_3_42;

import java.util.*;

public class RedBlackTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private final Node nil = new Node(-1);
    private Node root = nil;

    public Node getParent() {
        return root;
    }

    public class Node {
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

        Node(int key) {
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
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == nil) {
                    temp.right = node;
                    node.parent = temp;
                    isDuty = false;
                } else {
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
            } else if (node.parent.parent.left != null) {
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
            } else return;
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
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
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
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    List<Integer> getListElement(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null)
            return res;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            res.add(tempNode.key);
            if (tempNode.left != null && tempNode.left.key != -1) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null && tempNode.right.key != -1) {
                queue.add(tempNode.right);
            }
        }
        return res;
    }

    double getPercentageRedElementsRedBlackTree(Node node) {
        Pair number = getNumberDifferentColor(node);
        if (number.sum() == 0) {
            return 0;
        } else {
            return ((double) number.first() / (double) number.sum()) * 100;
        }
    }

    Pair getNumberDifferentColor(Node node) {
        Pair number = new Pair(0, 0);
        if (node == nil) {
            return number;
        } else {
            number.addNumber(getPairNumberColor(node));
            if (node.left != nil) {
                number.addNumber(getNumberDifferentColor(node.left));
            }
            if (node.right != nil) {
                number.addNumber(getNumberDifferentColor(node.right));
            }
        }
        return number;
    }

    Pair getPairNumberColor(Node node) {
        if (node.isRed()) {
            return new Pair(1, 0);
        } else {
            return new Pair(0, 1);
        }
    }
}

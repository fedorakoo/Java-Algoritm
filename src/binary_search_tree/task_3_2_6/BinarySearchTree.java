package binary_search_tree.task_3_2_6;

import java.util.Stack;

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
    public void printTree(Node node) {
        Stack globalStack = new Stack();
        globalStack.push(node);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (!isRowEmpty) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.key); // выводим его значение в консоли
                    localStack.push(temp.left);// соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
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

package balanced_search_tree.task_3_3_17;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        System.out.println("Сгенерируйте два случайных красно-черных ДБП из 8 узлов. Нарисуйте их (программно или от руки). Сравните их с (несбалансированным) ДБП, построенным из тех же ключей");
        outputTrees();
        outputTrees();
    }
    static void outputTrees() {
        System.out.print("\n\n");
        Random random = new SecureRandom();
        Set<Integer> mass = new HashSet<>();
        while(mass.size() < 8) {
            int randChild = random.nextInt(1,  100);
            mass.add(randChild);
        }
        BinarySearchTree bst = new BinarySearchTree();
        RedBlackTree rbt = new RedBlackTree();
        for (int number : mass) {
            bst.setParent(bst.insert(bst.getParent(), number));
            rbt.insert(number);
        }
        BinarySearchTree.printTree(bst.getParent());
        RedBlackTree.printTree(rbt.getParent());
    }
}
package balanced_search_tree.task_3_3_11;

public class Main {
    public static void main(String[] args) {
        System.out.println("Нарисуйте красно-черное ДПД, которое получится после вставки ключей E A S Y Q U T I O N в указанном порядке в первоначально пустое дерево.");
        RedBlackTree tree = new RedBlackTree();
        char[] massSymbol = new char[] {'E', 'A', 'S', 'Y', 'Q', 'U', 'T', 'I', 'O', 'N'};
        for (int i = 0; i < massSymbol.length; i++) {
            tree.insert(massSymbol[i]);
        }
        RedBlackTree.printTree(tree.getParent());
    }
}
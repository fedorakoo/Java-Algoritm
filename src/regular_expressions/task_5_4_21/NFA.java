package regular_expressions.task_5_4_21;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class NFA {
    private Digraph graph;
    private String regexp;
    private final int size;

    public NFA(String regexp) {
        this.regexp = regexp;
        size = regexp.length();
        Deque<Integer> stack = new ArrayDeque<>();
        graph = new Digraph(size + 1);
        for (int i = 0; i < size; i++) {
            int lp = i;
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|')
                stack.push(i);
            else if (regexp.charAt(i) == ')') {
                int or = stack.pop();

                if (regexp.charAt(or) == '|') {
                    lp = stack.pop();
                    graph.addEdge(lp, or + 1);
                    graph.addEdge(or, i);
                } else if (regexp.charAt(or) == '(')
                    lp = or;
                else assert false;
            }

            if (i < size - 1 && regexp.charAt(i + 1) == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            } else if (i < size - 1 && regexp.charAt(i + 1) == '+') {
                graph.addEdge(i + 1, lp);
            }

            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')' || regexp.charAt(i) == '+')
                graph.addEdge(i, i + 1);
        }
        if (stack.isEmpty())
            throw new IllegalArgumentException("Invalid regular expression");
    }

    public boolean recognizes(String txt) {
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        Bag<Integer> pc = new Bag<>();
        for (int v = 0; v < graph.V(); v++)
            if (dfs.marked(v)) pc.add(v);

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '*' || txt.charAt(i) == '|' || txt.charAt(i) == '(' || txt.charAt(i) == ')' || txt.charAt(i) == '+')
                throw new IllegalArgumentException("text contains the metacharacter '" + txt.charAt(i) + "'");
            Bag<Integer> bag = new Bag<>();
            for (int t : pc) {
                if (t == size) continue;
                if ((regexp.charAt(t) == txt.charAt(i)) || regexp.charAt(t) == '.')
                    bag.add(t + 1);
            }
            if (bag.isEmpty()) continue;

            dfs = new DirectedDFS(graph, bag);
            pc = new Bag<>();
            for (int t = 0; t < graph.V(); t++)
                if (dfs.marked(t)) pc.add(t);
            if (pc.size() == 0) return false;
        }

        for (int t : pc)
            if (t == size) return true;
        return false;
    }
}

package regular_expressions.task_5_4_19;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.Stack;

import java.util.Set;

public class NFA {
    private Digraph graph;
    private String regexp;
    private final int size;

    public NFA(String regexp) {
        this.regexp = regexp;
        size = regexp.length();
        Stack<Integer> ops = new Stack<>();
        graph = new Digraph(size + 1);
        for (int i = 0; i < size; i++) {
            int lp = i;
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|') {
                ops.push(i);
            } else if (regexp.charAt(i) == ')') {
                int or = ops.pop();
                if (regexp.charAt(or) == '|') {
                    lp = ops.pop();
                    graph.addEdge(lp, or + 1);
                    graph.addEdge(or, i);
                } else if (regexp.charAt(or) == '(') {
                    lp = or;
                } else {
                    assert false;
                }
            }

            if (i < size - 1 && regexp.charAt(i + 1) == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            }
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')') {
                graph.addEdge(i, i + 1);
            }
        }
        if (ops.size() != 0) {
            throw new IllegalArgumentException("Invalid regular expression");
        }
    }

    public boolean recognizesAnyFromSet(Set<String> stringSet) {
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < graph.V(); i++) {
            if (dfs.marked(i)) {
                bag.add(i);
            }
        }
        for (int t : bag) {
            if (t == size) {
                return true;
            }
            String s = regexp.substring(t, t + 1);
            if (stringSet.contains(s) || s.equals(".")) {
                dfs = new DirectedDFS(graph, t + 1);
                for (int nextV = 0; nextV < graph.V(); nextV++) {
                    if (dfs.marked(nextV)) {
                        bag.add(nextV);
                    }
                }
            }
        }
        return !bag.isEmpty();
    }

}
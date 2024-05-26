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
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|')
                ops.push(i);
            else if (regexp.charAt(i) == ')') {
                int or = ops.pop();

                if (regexp.charAt(or) == '|') {
                    lp = ops.pop();
                    graph.addEdge(lp, or + 1);
                    graph.addEdge(or, i);
                } else if (regexp.charAt(or) == '(')
                    lp = or;
                else assert false;
            }

            if (i < size - 1 && regexp.charAt(i + 1) == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            }
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')')
                graph.addEdge(i, i + 1);
        }
        if (ops.size() != 0)
            throw new IllegalArgumentException("Invalid regular expression");
    }

    public boolean recognizes(String txt) {
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        Bag<Integer> pc = new Bag<>();
        for (int v = 0; v < graph.V(); v++)
            if (dfs.marked(v)) pc.add(v);

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '*' || txt.charAt(i) == '|' || txt.charAt(i) == '(' || txt.charAt(i) == ')')
                throw new IllegalArgumentException("text contains the metacharacter '" + txt.charAt(i) + "'");

            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v == size) continue;
                if ((regexp.charAt(v) == txt.charAt(i)) || regexp.charAt(v) == '.')
                    match.add(v + 1);
            }
            if (match.isEmpty()) continue;

            dfs = new DirectedDFS(graph, match);
            pc = new Bag<>();
            for (int v = 0; v < graph.V(); v++)
                if (dfs.marked(v)) pc.add(v);
            if (pc.size() == 0) return false;
        }

        for (int v : pc)
            if (v == size) return true;
        return false;
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
            String s = regexp.substring(t, t+1);
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
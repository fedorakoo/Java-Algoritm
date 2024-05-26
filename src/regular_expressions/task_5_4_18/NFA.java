package regular_expressions.task_5_4_18;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.Stack;

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
            } else if (i < size - 1 && regexp.charAt(i + 1) == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            } else if (i < size - 1 && regexp.charAt(i + 1) == '+') {
                graph.addEdge(i + 1, i);
            }
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')' || regexp.charAt(i) == '+') {
                graph.addEdge(i, i + 1);
            }
        }
        if (ops.size() != 0) {
            throw new IllegalArgumentException("Invalid regular expression");
        }
    }

    public boolean recognizes(String txt) {
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        Bag<Integer> pc = new Bag<>();
        for (int v = 0; v < graph.V(); v++) {
            if (dfs.marked(v)) pc.add(v);
        }
        for (int i = 0; i < txt.length(); i++) {
            char currentChar = txt.charAt(i);
            if (currentChar == '*' || currentChar == '|' || currentChar == '(' || currentChar == ')') {
                throw new IllegalArgumentException("Текст содержит метасимвол '" + currentChar + "'");
            }

            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v == size) {
                    continue;
                }
                char regexpChar = regexp.charAt(v);
                if (regexpChar == currentChar || regexpChar == '.') {
                    match.add(v + 1);
                } else if (regexpChar == '[' && i < size - 2 && regexp.charAt(v + 2) == currentChar) {
                    match.add(v + 3);
                }
            }
            if (match.isEmpty()) {
                continue;
            }
            dfs = new DirectedDFS(graph, match);
            pc = new Bag<>();
            for (int v = 0; v < graph.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
            if (pc.isEmpty()) {
                return false;
            }
        }
        for (int v : pc) {
            if (v == size) {
                return true;
            }
        }
        return false;
    }
}


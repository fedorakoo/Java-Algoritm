package balanced_search_tree.task_3_3_42;

public class Pair {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int first() {
        return first;
    }
    public int second() {
        return second;
    }
    void addNumber(Pair number) {
        first += number.first;
        second += number.second;
    }
    int sum() {
        return first + second;
    }
}

package hash_table.task_3_4_9;

public class SeparateChainingHashST<Key, Value> {
    private int size;
    private Node[] arr;

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next)  {
            this.key  = key;
            this.value  = value;
            this.next = next;
        }
    }

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int size) {
        this.size = size;
        arr = new Node[size];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node x = arr[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        for (Node x = arr[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                System.out.println("Элемент с таким ключем уже существует");
                x.value = value;
                return;
            }
        }
        arr[i] = new Node(key, value, arr[i]);
        System.out.println("Элемент успешно добавлен");
    }

    public void delete(Key key) {
        int i = hash(key);
        arr[i] = delete(arr[i], key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            System.out.println("Элемент успешно удален");
            return x.next;
        }
        x.next = delete(x.next, key);
        System.out.println("Данного элемента не существует");
        return x;
    }

    void output() {
        for(int i = 0; i < size; i++) {
            if(arr[i] != null) {
                System.out.print("[" + i + "]: ");
                for (Node x = arr[i]; x != null; x = x.next) {
                    System.out.print(x.value + " ");
                }
                System.out.println();
            }
        }
    }
}

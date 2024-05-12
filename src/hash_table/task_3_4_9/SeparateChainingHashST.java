package hash_table.task_3_4_9;

public class SeparateChainingHashST<T1, T2> {
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

    private int hash(T1 key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public T2 get(T1 key) {
        int i = hash(key);
        for (Node x = arr[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (T2) x.value;
        }
        return null;
    }

    public void put(T1 key, T2 value) {
        int i = hash(key);
        for (Node x = arr[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                System.out.println("Элемент с таким ключом уже существует");
                return;
            }
        }
        arr[i] = new Node(key, value, arr[i]);
        System.out.println("Элемент успешно добавлен");
    }

    public void delete(T1 key) {
        int i = hash(key);
        arr[i] = delete(arr[i], key);
    }

    private Node delete(Node x, T1 key) {
        if (x == null) {
            System.out.println("Элемента с данным ключом не существует");
            return null;
        }
        if (key.equals(x.key)) {
            System.out.println("Элемент успешно удален");
            return x.next;
        }
        x.next = delete(x.next, key);
        System.out.println("Элемента с данным ключом не существует");
        return x;
    }

    void output() {
        int number = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] != null) {
                System.out.print("[" + i + "]: ");
                for (Node x = arr[i]; x != null; x = x.next) {
                    System.out.print(x.value + " ");
                }
                System.out.println();
                number++;
            }
        }
        if(number == 0) {
            System.out.println("Хеш-таблица пуста");
        }
    }
}

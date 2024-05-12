package hash_table.task_3_4_17;

public class LinearProbingHashST<T1, T2>
{
    private int size;
    private int capasity = 16;
    private T1[] keys;
    private T2[] values;

    public LinearProbingHashST()
    {
        keys = (T1[]) new Object[capasity];
        values = (T2[]) new Object[capasity];
    }
    public LinearProbingHashST(int capasity)
    {
        this.size = capasity;
        keys = (T1[]) new Object[this.capasity];
        values = (T2[]) new Object[this.capasity];
    }

    private int hash(T1 key)
    {
        return (key.hashCode() & 0x7fffffff) % capasity;
    }

    public void resize(int capacity) {
        LinearProbingHashST<T1, T2> t = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < capasity; i++)
            if (keys[i] != null)
                t.put(keys[i], values[i]);
        keys = t.keys;
        values = t.values;
        capasity = t.capasity;
    }

    public void put(T1 key, T2 val)
    {
        if (size >= capasity /2) resize(2* capasity);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capasity)
            if (keys[i].equals(key)) {
                System.out.println("Элемент с таким ключем уже существует");
                return;
            }
        keys[i] = key;
        values[i] = val;
        size++;
        System.out.println("Элемент успешно добавлен");
    }

    public T2 get(T1 key)
    {
        for(int i = hash(key); keys[i] != null; i= (i + 1) % capasity)
            if(keys[i].equals(key))
                return values[i];
        return null;
    }

    public void delete(T1 key)
    {
        if(get(key) == null)  {
            System.out.println("Данного элемента не существует");
        }
        else {
            int i = hash(key);
            while (!key.equals(keys[i]))
                i = (i + 1) % capasity;
            keys[i] = null;
            values[i] = null;
            i = (i + 1) % capasity;
            while (keys[i] != null) {
                T1 keyToRedo = keys[i];
                T2 valToRedo = values[i];
                keys[i] = null;
                values[i] = null;
                size--;
                put(keyToRedo, valToRedo);
                i = (i + 1) % capasity;
            }
            size--;
            if (size > 0 && size == capasity / 8) {
                resize(capasity / 2);
            }
            System.out.println("Элемент успешно удален");
        }
    }
    public void output() {
        int number = 0;
        for (int i = 0; i < capasity; i++) {
            if (keys[i] != null) {
                number++;
                System.out.println("Number [" + i + "] Key: " + keys[i].toString() + ", Value: " + values[i].toString());
            }
        }
        if(number == 0) {
            System.out.println("Хеш-таблица пуста");
        }
    }

}

package hash_table.task_3_4_17;

public class LinearProbingHashST<Key, Value>
{
    private int size;
    private int capasity = 16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST()
    {
        keys = (Key[]) new Object[capasity];
        vals = (Value[]) new Object[capasity];
    }
    public LinearProbingHashST(int capasity)
    {
        this.size = capasity;
        keys = (Key[]) new Object[this.capasity];
        vals = (Value[]) new Object[this.capasity];
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % capasity;
    }

    public void resize(int capacity) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < capasity; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        capasity = t.capasity;
    }

    public void put(Key key, Value val)
    {
        if (size >= capasity /2) resize(2* capasity);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capasity)
            if (keys[i].equals(key)) {
                System.out.println("Элемент с таким ключем уже существует");
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        size++;
        System.out.println("Элемент успешно добавлен");
    }

    public Value get(Key key)
    {
        for(int i = hash(key); keys[i] != null; i= (i + 1) % capasity)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key)
    {
        if(get(key) == null)  {
            System.out.println("Данного элемента не существует");
        }
        else {
            int i = hash(key);
            while (!key.equals(keys[i]))
                i = (i + 1) % capasity;
            keys[i] = null;
            vals[i] = null;
            i = (i + 1) % capasity;
            while (keys[i] != null) {
                Key keyToRedo = keys[i];
                Value valToRedo = vals[i];
                keys[i] = null;
                vals[i] = null;
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
        for (int i = 0; i < capasity; i++) {
            if (keys[i] != null) {
                System.out.println("Number [" + i + "] Key: " + keys[i].toString() + ", Value: " + vals[i].toString());
            }
        }
    }

}

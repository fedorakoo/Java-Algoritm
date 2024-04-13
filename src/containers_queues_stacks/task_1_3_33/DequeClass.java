package containers_queues_stacks.task_1_3_33;

import java.util.Scanner;

public class DequeClass<Item> {
    Scanner in = new Scanner(System.in);

    public DequeClass(int newSize) {
        size = newSize;
        arr = (Item[]) new Object[size];
    }

    public void inputArray() {
        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент номер " + Integer.toString(i + 1) + ": ");
            arr[i] = (Item) in.nextLine();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }

    public void pushLeft(Item item) {
        arr = (Item[]) resizingArrayDeque.getArrLargerOneFirstLeft(arr, size);
        size++;
        arr[0] = item;
    }

    public void pushRight(Item item) {
        arr = (Item[]) resizingArrayDeque.getArrLargerOneFirstRight(arr, size);
        arr[size] = item;
        size++;
    }

    public Item popLeft() {
        if (!isEmpty()) {
            Item result = arr[0];
            arr = (Item[]) resizingArrayDeque.getArrSmallerOneFirstLeft(arr, size);
            size--;
            return result;
        }
        return null;
    }

    public Item popRight() {
        if (!isEmpty()) {
            Item result = arr[size - 1];
            arr = (Item[]) resizingArrayDeque.getArrSmallerOneFirstRight(arr, size);
            size--;
            return result;
        }
        return null;
    }

    void changeElement(Item item, int index) {
        arr[index] = item;
    }

    public void ouputArray() {
        StringBuilder bld = new StringBuilder();
        System.out.print("Значение всех элементов в массиве: ");
        for (int i = 0; i < arr.length; i++) {
            bld.append(arr[i] + " ");
        }
        System.out.print(bld.toString() + "\n");
    }

    private ResizingArrayDeque resizingArrayDeque = new ResizingArrayDeque();
    private Item[] arr;
    private int size;
}

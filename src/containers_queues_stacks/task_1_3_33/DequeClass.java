package containers_queues_stacks.task_1_3_33;

import java.util.Scanner;

public class DequeClass<T> {
    Scanner in = new Scanner(System.in);

    public DequeClass(int newSize) {
        size = newSize;
        arr = (T[]) new Object[size];
    }

    public void inputArray() {
        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент номер " + Integer.toString(i + 1) + ": ");
            arr[i] = (T) in.nextLine();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }

    public void pushLeft(T item) {
        arr = (T[]) resizingArrayDeque.getArrLargerOneFirstLeft(arr, size);
        size++;
        arr[0] = item;
    }

    public void pushRight(T item) {
        arr = (T[]) resizingArrayDeque.getArrLargerOneFirstRight(arr, size);
        arr[size] = item;
        size++;
    }

    public T popLeft() {
        if (!isEmpty()) {
            T result = arr[0];
            arr = (T[]) resizingArrayDeque.getArrSmallerOneFirstLeft(arr, size);
            size--;
            return result;
        }
        return null;
    }

    public T popRight() {
        if (!isEmpty()) {
            T result = arr[size - 1];
            arr = (T[]) resizingArrayDeque.getArrSmallerOneFirstRight(arr, size);
            size--;
            return result;
        }
        return null;
    }

    void changeElement(T item, int index) {
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

    private ResizingArrayDeque<T> resizingArrayDeque = new ResizingArrayDeque<>();
    private T[] arr;
    private int size;
}

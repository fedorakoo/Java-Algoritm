package task_1_3_33;

import java.util.Scanner;

public class Degue<Item>
{
    Scanner in = new Scanner(System.in);
    public Degue(int newSize) {
        size = newSize;
        arr = (Item[]) new Object[size];
    }
    public void inputArray() {
        for(int i = 0; i < size; i++) {
            System.out.print("Введите элемент номер " + Integer.toString(i + 1) + ": ");
            arr[i] = (Item) in.nextLine();
        }
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int getSize() {
        return size;
    }
    public void pushLeft(Item item) {
        arr = (Item[])resizingArrayDeque.getArrLargerOneFirstLeft(arr, size);
        size++;
        arr[0] = item;
    }
    public void pushRight(Item item) {
        arr = (Item[])resizingArrayDeque.getArrLargerOneFirstRight(arr, size);
        arr[size] = item;
        size++;
    }
    public Item popLeft() {
        if(!isEmpty()) {
            Item result = arr[0];
            arr = (Item[]) resizingArrayDeque.getArrSmallerOneFirstLeft(arr, size);
            size--;
            return result;
        }
        return null;
    }
    public Item popRight() {
        if(!isEmpty()) {
            Item result = arr[size - 1];
            arr = (Item[]) resizingArrayDeque.getArrSmallerOneFirstRight(arr, size);
            size--;
            return result;
        }
        return null;
    }
    public String ouputArray() {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result +=  arr[i] + " ";
        }
        result += '\n';
        return result;
    }
    private ResizingArrayDeque resizingArrayDeque = new ResizingArrayDeque();
    private Item[] arr;
    private int size;
}

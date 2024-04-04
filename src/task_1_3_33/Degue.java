package task_1_3_33;

public class Degue<Item>
{
    public Degue(int newSize) {
        size = newSize;
        arr = (Item[]) new Object[size];
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
        Item result = arr[0];
        arr = (Item[])resizingArrayDeque.getArrSmallerOneFirstLeft(arr, size);
        size--;
        return result;
    }
    public Item popRight() {
        Item result = arr[size - 1];
        arr = (Item[])resizingArrayDeque.getArrSmallerOneFirstRight(arr, size);
        size--;
        return result;
    }
    public void ouputArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
    private ResizingArrayDeque resizingArrayDeque = new ResizingArrayDeque();
    private Item[] arr;
    private int size;
}

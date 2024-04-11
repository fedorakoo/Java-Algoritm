package containers_queues_stacks.task_1_3_33;

public class ResizingArrayDeque<Item> {
    public Item[] getArrLargerOneFirstLeft(Item[] arr, int size) {
        Item[] newArr = (Item[]) new Object[size + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public Item[] getArrLargerOneFirstRight(Item[] arr, int size) {
        Item[] newArr = (Item[]) new Object[size + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public Item[] getArrSmallerOneFirstLeft(Item[] arr, int size) {
        Item[] newArr = (Item[]) new Object[size - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }
        return newArr;
    }

    public Item[] getArrSmallerOneFirstRight(Item[] arr, int size) {
        Item[] newArr = (Item[]) new Object[size - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
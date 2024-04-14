package containers_queues_stacks.task_1_3_33;

import java.util.Arrays;

public class ResizingArrayDeque<T> {
    public T[] getArrLargerOneFirstLeft(T[] arr, int size) {
        T[] newArr = Arrays.copyOf(arr, size + 1);
        for (int i = size; i > 0; i--) {
            newArr[i] = newArr[i - 1];
        }
        newArr[0] = null;
        return newArr;
    }

    public T[] getArrLargerOneFirstRight(T[] arr, int size) {
        T[] newArr = Arrays.copyOf(arr, size + 1);
        newArr[size] = null;
        return newArr;
    }

    public T[] getArrSmallerOneFirstLeft(T[] arr, int size) {
        T[] newArr = Arrays.copyOfRange(arr, 1, size - 1);
        newArr[0] = null;
        return newArr;
    }

    public T[] getArrSmallerOneFirstRight(T[] arr, int size) {
        T[] newArr = Arrays.copyOf(arr, size - 1);
        for (int i = size; i > 0; i--) {
            newArr[i] = newArr[i - 1];
        }
        return newArr;
    }
}
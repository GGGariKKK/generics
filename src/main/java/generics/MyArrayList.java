package generics;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private Object[] data;
    private int pointer;

    public MyArrayList() {
        data = new Object[1];
    }

    public void add(T value) {
        if (pointer == data.length)
            data = Arrays.copyOf(data, data.length * 2);
        data[pointer++] = value;
    }

    public T remove(int index) {
        Objects.checkIndex(index, pointer);
        var removed = data[index];

        for (int i = index + 1; i < size(); i++)
            data[i - 1] = data[i];

        pointer--;
        return (T) removed;
    }

    public void clear() {
        data = new Object[1];
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public T get(int index) {
        if (index >= pointer)
            throw new IndexOutOfBoundsException();
        return (T) data[index];
    }
}

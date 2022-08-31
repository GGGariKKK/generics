package generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private final static int DEFAULT_SIZE = 5;
    private Object[] data;
    private int pointer;

    public MyArrayList() {
        data = new Object[DEFAULT_SIZE];
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
        data = new Object[DEFAULT_SIZE];
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

    @Override
    public String toString() {
        return Arrays.stream(data)
                .filter(Objects::nonNull)
                .map(obj -> (T)obj)
                .reduce(new StringJoiner(", ", "[", "]"), (sJoiner, val) -> sJoiner.add(val.toString()), (x, y) -> x)
                .toString();
    }
}

package generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class MyArrayList<T> {
    private final static int DEFAULT_SIZE = 5;
    private Object[] data;
    private int pointer;

    public MyArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (pointer == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[pointer++] = value;
    }

    public T remove(int index) {
        Objects.checkIndex(index, pointer);
        T removed = (T) data[index];

        for (int i = index + 1; i < size(); i++) {
            data[i - 1] = data[i];
        }

        pointer--;
        return removed;
    }

    public void clear() {
        data = new Object[DEFAULT_SIZE];
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public T get(int index) {
        Objects.checkIndex(index, pointer);
        return (T) data[index];
    }

    @Override
    public String toString() {
        return IntStream.range(0, pointer)
                .mapToObj(i -> (T) data[i])
                .reduce(new StringJoiner(", ", "[", "]"), (sJoiner, val) -> sJoiner.add(Objects.requireNonNullElse(val, "null").toString()), (x, y) -> x)
                .toString();
    }
}

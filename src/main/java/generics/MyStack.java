package generics;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.StringJoiner;

public class MyStack<T> {
    private static final int DEFAULT_SIZE = 3;

    private Object[] stack;
    private int pointer;

    public MyStack() {
        stack = new Object[DEFAULT_SIZE];
        pointer = -1;
    }

    public void push(T value) {
        if (pointer + 1 >= stack.length)
            stack = Arrays.copyOf(stack, stack.length * 2);
        stack[++pointer] = value;
    }

    public boolean remove(T value) {
        for (int i = 0; i <= pointer; i++)
            if (stack[i] == value) {
                System.arraycopy(stack, i + 1, stack, i, stack.length - i - 1);
                pointer--;
                return true;
            }
        return false;
    }

    public void clear(){
        stack = new Object[DEFAULT_SIZE];
        pointer = -1;
    }

    public int size(){
        return pointer + 1;
    }

    public T peek(){
        if(pointer == -1)
            throw new EmptyStackException();
        return (T) stack[pointer];
    }

    public T pop(){
        if(pointer == -1)
            throw new EmptyStackException();
        return (T) stack[pointer--];
    }

    @Override
    public String toString() {
        var result = new StringJoiner(", ", "[", "]");
        for (int i = 0; i <= pointer; i++)
            result.add(Objects.requireNonNullElse(stack[i], "null").toString());
        return result.toString();
    }
}

package generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MyQueue<T> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] values;
    private int head;
    private int tail;

    public MyQueue(){
        values = new Object[DEFAULT_SIZE];
    }

    public void add(T value){
        if (tail >= values.length)
            values = Arrays.copyOf(values, values.length * 2);
        values[tail++] = value;
    }

    public T peek(){
        return (T) values[head];
    }

    public T poll(){
        if (head == tail)
            return null;
        return (T) values[head++];
    }

    public boolean remove(T value){
        for(int i = head; i <= tail; i++){
            if (values[i] == value){
                for(int j = i + 1; j < tail; j++)
                    values[j - 1] = values[j];
                tail--;
                return true;
            }
        }
        return false;
    }

    public void clear(){
        values = new Object[DEFAULT_SIZE];
        head = tail = 0;
    }

    public int size(){
        return tail - head;
    }

    @Override
    public String toString() {
        var res = new StringJoiner(", ", "[", "]");
        for(int i = head; i < tail; i++)
            res.add(Objects.requireNonNullElse(values[i], "null").toString());
        return res.toString();
    }

}

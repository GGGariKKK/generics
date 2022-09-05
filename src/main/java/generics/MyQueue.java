package generics;

import java.util.Objects;
import java.util.StringJoiner;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        if (head == null) {
            head = new Node<>(null, value);
            tail = head;
        } else {
            tail.next = new Node<>(null, value);
            tail = tail.next;
        }
        size++;
    }

    public T peek() {
        return head == null ? null : head.value;
    }

    public T poll() {
        if (head != null) {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return null;
    }

    public boolean remove(T value) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.value == value) {
                if (current == head) {
                    head = head.next;
                } else {
                    previous.next = current.next;
                    current.next = null;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringJoiner result = new StringJoiner(", ", "[ ", " ]");
        while (current != null) {
            result.add(Objects.requireNonNullElse(current.value, "null").toString());
            current = current.next;
        }
        return result.toString();
    }

    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }
}

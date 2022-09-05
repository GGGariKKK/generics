package generics;

import java.util.Objects;
import java.util.StringJoiner;

public class MyLinkedList<T> {
    private Node<T> head;
    private int length;

    public void add(T value) {
        if (head == null) {
            head = new Node<>(null, null, value);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(null, current, value);
        }
        length++;
    }

    public T remove(int index) {
        Objects.checkIndex(index, length);

        Node<T> current = head;

        while (index-- != 0) current = current.next;

        if (current == head) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        }

        if (current.previous != null) current.previous.next = current.next;
        if (current.next != null) current.next.previous = current.previous;

        length--;
        return current.value;
    }

    public void clear() {
        head = null;
        length = 0;
    }

    public int size() {
        return length;
    }

    public T get(int index) {
        Objects.checkIndex(index, length);

        Node<T> current = head;
        while (index-- != 0) current = current.next;

        return current.value;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        Node<T> current = head;
        while (current != null) {
            result.add(Objects.requireNonNullElse(current.value, "null").toString());
            current = current.next;
        }
        return result.toString();
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T value;

        public Node(Node<T> next, Node<T> previous, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }

}

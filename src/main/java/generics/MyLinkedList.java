package generics;

import java.util.Objects;
import java.util.StringJoiner;

public class MyLinkedList<T> {
    private Node<T> head;
    private int length;

    public void add(T value) {
        if (head == null)
            head = new Node<>(null, null, value);
        else {
            var curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = new Node<>(null, curr, value);
        }
        length++;
    }

    public T remove(int index) {
        Objects.checkIndex(index, length);

        var curr = head;

        while (index-- != 0) curr = curr.next;

        if (curr == head) {
            head = head.next;

            if (head != null)
                head.previous = null;
        }

        if (curr.previous != null) curr.previous.next = curr.next;
        if (curr.next != null) curr.next.previous = curr.previous;

        length--;
        return curr.value;
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

        var curr = head;
        while (index-- != 0) curr = curr.next;
        return curr.value;
    }

    @Override
    public String toString() {
        var res = new StringJoiner(", ", "[", "]");
        var curr = head;
        while (curr != null) {
            res.add(Objects.requireNonNullElse(curr.value, "null").toString());
            curr = curr.next;
        }
        return res.toString();
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

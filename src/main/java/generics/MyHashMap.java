package generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> {
    private static final int DEFAULT_SIZE = 7;
    private static final double DEFAULT_LOAD_FACTOR = 0.6;

    private Object[] values;

    public MyHashMap() {
        values = new Object[DEFAULT_SIZE];
    }

    public V put(K key, V value) {
        if (1.0 * size() / values.length >= DEFAULT_LOAD_FACTOR)
            rehash();

        int index = key == null ? 0 : key.hashCode() % values.length;
        Entry<K, V> entryToPut = new Entry<>(key, value);

        if (values[index] == null) {
            MyLinkedList<Entry<K, V>> temporary = new MyLinkedList<>();
            temporary.add(entryToPut);
            values[index] = temporary;
        } else {
            MyLinkedList<Entry<K, V>> list = ((MyLinkedList<Entry<K, V>>) values[index]);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getKey() == key) {
                    list.add(entryToPut);
                    return list.remove(i).getValue();
                }
            }
            list.add(entryToPut);
        }
        return null;
    }

    public V remove(K key) {
        var index = key.hashCode() % values.length;

        if (values[index] != null) {
            MyLinkedList<Entry<K, V>> entries = (MyLinkedList<Entry<K, V>>) values[index];
            for (int i = 0; i < entries.size(); i++) {
                if (entries.get(i).getKey() == key) {
                    return entries.remove(i).getValue();
                }
            }
        }
        return null;
    }

    public void clear() {
        values = new Object[DEFAULT_SIZE];
    }

    public int size() {
        return (int) Arrays.stream(values)
                .filter(obj -> Objects.nonNull(obj) && ((MyLinkedList) obj).size() != 0)
                .count();
    }

    public V get(K key) {
        int index = key == null ? 0 : key.hashCode() % values.length;
        MyLinkedList<Entry<K, V>> entries = (MyLinkedList<Entry<K, V>>) values[index];
        for (int i = 0; entries != null && i < entries.size(); i++) {
            if (entries.get(i).getKey() == key) {
                return entries.get(i).getValue();
            }
        }
        return null;
    }

    private void rehash() {
        Object[] oldValues = values;
        values = new Object[values.length * 2];

        for (Object oldValue : oldValues) {
            if (oldValue != null) {
                MyLinkedList<Entry<K, V>> entries = ((MyLinkedList<Entry<K, V>>) oldValue);
                for (int j = 0; j < entries.size(); j++) {
                    put(entries.get(j).getKey(), entries.get(j).getValue());
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(values)
                .filter(obj -> Objects.nonNull(obj) && ((MyLinkedList) obj).size() != 0)
                .map(obj -> (MyLinkedList<Entry<K, V>>) obj)
                .reduce(new StringJoiner(", ", "[", "]"), (sJoiner, listOfEntries) -> sJoiner.add(listOfEntries.toString()), (z, g) -> z)
                .toString();
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.format("%s = %s", Objects.requireNonNullElse(key, "null"), Objects.requireNonNullElse(value, "null"));
        }
    }
}

package generics;

public class GenericsTest {
    public static void main(String[] args) {
        myArrayListTest();
        System.out.println("\n\n");

        myLinkedListTest();
        System.out.println("\n\n");

        myQueueTest();
        System.out.println("\n\n");

        myStackTest();
        System.out.println("\n\n");

        myHashMapTest();
    }

    public static void myArrayListTest() {
        var arList = new MyArrayList<String>();
        arList.add("a");
        arList.add("b");
        arList.add("c");

        System.out.println(arList);

        arList.remove(1);

        System.out.println(arList);

        System.out.println(arList.get(1));

        arList.clear();

        System.out.println(arList);

        System.out.println(arList.size());
    }

    public static void myLinkedListTest() {
        var lList = new MyLinkedList<String>();
        lList.add("a");
        lList.add("b");
        lList.add("c");

        System.out.println(lList);

        lList.remove(1);

        System.out.println(lList);

        System.out.println(lList.get(1));

        lList.clear();

        System.out.println(lList);

        System.out.println(lList.size());
    }

    public static void myQueueTest() {
        var queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.remove(2));
        System.out.println(queue);
        queue.clear();
        System.out.println(queue);
    }

    public static void myStackTest() {
        var stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.remove(2));
        System.out.println(stack);
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack);
    }

    public static void myHashMapTest(){
        var map = new MyHashMap<Integer, Character>();

        map.put((int)'a', 'a');
        map.put((int)'b', 'b');
        map.put((int)'c', 'c');

        System.out.println(map);

        //Let's make a collision:
        map.put((int)'i', 'i');

        System.out.println(map);

        //Let's put more entries to make hashtable rehash itself
        map.put((int)'d', 'd');
        map.put((int)'e', 'e');
        map.put((int)'f', 'f');

        //In output we can see that 'b' and 'i' values are not in the same bucket now, that is because size of hashtable increased by two times (from 7 to 14) and the values computed by hash function differ
        System.out.println(map);

        map.remove((int)'e');

        System.out.println(map);

        System.out.println(map.get(97));

        map.clear();

        System.out.println(map);
    }
}

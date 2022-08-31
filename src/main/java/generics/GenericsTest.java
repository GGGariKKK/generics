package generics;

public class GenericsTest {
    public static void main(String[] args) {
        //myArrayListTest();

        //myLinkedListTest();

        //myQueueTest();

        myStackTest();
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
}

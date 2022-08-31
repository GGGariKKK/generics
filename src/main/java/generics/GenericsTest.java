package generics;

public class GenericsTest {
    public static void main(String[] args) {
        //myArrayListTest();
        
        //myLinkedListTest();

        myQueueTest();
    }


    public static void myArrayListTest(){
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
    
    private static void myLinkedListTest() {
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

    private static void myQueueTest() {
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
}

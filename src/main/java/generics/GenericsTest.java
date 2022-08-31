package generics;

public class GenericsTest {
    public static void main(String[] args) {
        //myArrayListTest();
        
        myLinkedListTest();
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
}

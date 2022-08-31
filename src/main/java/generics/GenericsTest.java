package generics;

public class GenericsTest {
    public static void main(String[] args) {
        myArrayListTest();
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
}

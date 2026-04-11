import MyArrays.MyArrayList;
import MyArrays.MyLinkedList;

import java.util.LinkedList;

public class MyApp {
public static void main(String[] args){

    MyLinkedList linked = new MyLinkedList<>();

    linked.add(4);
    linked.add(6);
    linked.add(7);
    linked.add(3);
    linked.add(8);

    linked.show();

    System.out.println(" ");
    System.out.println(" ");

    linked.sort();

    linked.show();

}
}

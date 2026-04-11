import MyArrays.MyArrayList;
import MyArrays.MyLinkedList;

import java.util.LinkedList;

public class MyApp {
public static void main(String[] args){

    LinkedList<String> link = new LinkedList<String>();

    MyArrayList<Integer> arr = new MyArrayList<Integer>();

    arr.add(10);
    arr.add(9);
    arr.add(4);
    arr.add(5);
    arr.add(8);
    arr.add(3);

    arr.sort();

    arr.show();



}
}

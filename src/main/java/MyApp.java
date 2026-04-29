import MyArrays.MyArrayList;
import MyArrays.MyHashTable;
import MyArrays.MyLinkedList;
import MyArrays.MyMinHeap;

import java.util.LinkedList;
import MyArrays.BST;

public class MyApp {
public static void main(String[] args){


    MyHashTable<String,Integer> ht = new MyHashTable<>();

    ht.put("apple",1);
    ht.put("mango",2);
    ht.put("melon",3);

    System.out.println(ht.get("mango"));
    System.out.println(ht.getKey(3));

    System.out.println(ht.remove("melon"));
    System.out.println();

    System.out.println(ht.get("melon"));



    System.out.println("===== BST =====");

    BST<Integer, String> tree = new BST<>();
    tree.put(5, "five");
    tree.put(3, "three");
    tree.put(7, "seven");
    tree.put(1, "one");
    tree.put(4, "four");
    tree.put(6, "six");
    tree.put(8, "eight");

    System.out.println(tree.get(3));   // three
    System.out.println(tree.get(7));   // seven
    System.out.println(tree.size());     // 7

    System.out.println("In-order traversal:");
    for (var elem : tree) {
        System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
    }



}
}

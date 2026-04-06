import MyArrays.MyArrayList;

public class MyApp {
public static void main(String[] args){

    MyArrayList<Integer> arr = new MyArrayList<Integer>();

    arr.add(10);
    arr.add(9);
    arr.add(4);
    arr.add(5);
    arr.add(8);
    arr.add(3);


    arr.removeLast();
    System.out.println(arr.indexOf(4));

}
}

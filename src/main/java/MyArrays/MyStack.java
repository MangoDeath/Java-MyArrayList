package MyArrays;
import java.util.NoSuchElementException;

public class MyStack<T extends Comparable<T>> {

    private MyArrayList<T> list = new MyArrayList<>();

    public void push (T item){
        list.addLast(item);
    }


    public boolean isEmpty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    public T pop() {
        if(isEmpty()) throw new NoSuchElementException();
        T value = list.getLast();
        list.removeLast();
        return value;
    }

    public T peek(){
        if(isEmpty())throw new NoSuchElementException();
        return list.getLast();
    }



}

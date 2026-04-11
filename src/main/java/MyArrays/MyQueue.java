package MyArrays;
import java.util.NoSuchElementException;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        if (isEmpyt()) throw new NoSuchElementException();
        T value = list.getFirst();
        list.removeFirst();
        return value;
    }

    public boolean isEmpyt(){
        return list.size()==0;
    }

    public T peek(){
        if(isEmpyt()) throw new NoSuchElementException();
        return list.getFirst();
    }

    public int size(){
        return list.size();
    }
}

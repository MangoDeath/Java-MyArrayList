package MyArrays;


import java.util.Iterator;

public class MyArrayList <T extends Comparable<T>> implements MyList<T> {

    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList(){
        array = new Object[capacity];
    }


    private void increaseBuffer(){
        capacity = (int)(1.5* capacity);
        Object [] arr2 = new Object[capacity];
        for(int i =0; i<size;i++){
            arr2[i] = array[i];
        }
        array = arr2;
    }



        public void show(){
        int count = 0;
        while(count < size && array[count]!=null){
            System.out.println(array[count]);
            count++;

        }
    }


    @Override
    public void add(T item) {
        if(size == capacity){
            increaseBuffer();
        }
        array[size]=item;
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == capacity) {
            increaseBuffer();}

        for(int i =size ;i<index ;i--){
            array[i+1]= array[i];
        }
        array[index] = item;

    }

    public void set(int index , T item){
        array[index]= item;
    }

    @Override
    public void addFirst(T item) {
        if(size ==capacity){
            increaseBuffer();}

        for(int i=size; i<0;i--) {
            array[i+1]=array[i];
        }
        array[0]=item;

    }

    @Override
    public void addLast(T item) {
        if(size==capacity){
            increaseBuffer();}
        array[size]=item;

    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        return (T) array[0];
    }

    @Override
    public T getLast() {
        return (T) array[size-1];
    }

    @Override
    public void remove(int index) {
        for(int i =index; i<size-1;i++) {
        array[i]=array[i+1];
        }
        size--;
        array[size] = null;
    }

    @Override
    public T removeFirst() {
        for(int i =0; i<size-1;i++) {
            array[i]=array[i+1];
        }
        size--;
        array[size] = null;
        return null;
    }

    @Override
    public T removeLast() {
        array[size-1]=null;
        size--;
        return null;
    }

    @Override
    public void sort() {

    for(int i =0; i<size-1; i++){
        for(int j =0; j<size-i-1;j++){
            if ((int)array[j]>(int)array[j+1]){
                int temp = (int)array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }

    }

    @Override
    public int indexOf(Object object) {
        for(int i=0; i<size;i++){
            if(array[i]==object){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i =size-1; i>=0;i--){
            if(array[i].equals(object)){
                return i;
            }
        }
    return -1;
    }

    @Override
    public boolean exists(Object object) {
        for (int i =0; i<size;i++){
            if(array[i].equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

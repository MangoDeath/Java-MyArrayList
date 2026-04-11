package MyArrays;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <T extends Comparable<T>> implements MyList<T> {

    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
        public MyLinkedList(){
            head = null;
            tail=null;
            size = 0;
        }

    @Override
    public void add(T item) {

    }

    public void addFirst(T item){

            MyNode newNode = new MyNode(item);

            if(head==null){
                head = tail = newNode;
            }
            else{
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        size++;
        }

        public void addLast(T item){
            MyNode newNode = new MyNode(item);

            if (tail==null){
                head = tail = newNode;
            }
            else{
                tail.next= newNode;
                tail.prev=tail;
                tail = newNode;
            }
            size++;
        }

        public T removeFirst(){

            T value = head.data;

            if(head == tail){
                head = tail=null;
            }else{
                head =head.next;
                head.prev=null;
            }
            size--;
            return value;
        }

        public T removeLast(){

        T value = tail.data;

        if(tail==null){
            throw new NoSuchElementException("Theres no last element");
        }

        if(head ==tail){
                head = tail = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;
            }
            size--;

            return value;
        }

        public T get(int index){
        if(index <0 || index >=size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyNode currentNode = head;
        for (int i= 0; i<index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.data;

    }

    public void add(int index, T item){

    if (index ==0){
        addFirst(item);
        return;
    }
    if(index==size){
        addLast(item);
        return;
    }

    MyNode newNode = new MyNode(item);
    MyNode currentNode = head;

    for (int i=0; i<index-1;i++){
        currentNode = currentNode.next;
    }

    newNode.next=currentNode.next;

    if(currentNode.next !=null){
        currentNode.next.prev=newNode;
        }

    currentNode.next = newNode;
    newNode.prev=currentNode;
    size++;
    }

    @Override
    public void set(int index, T item) {

        MyNode currentNode = head;
        MyNode newNode = new MyNode(item);

        for (int i=0;i <index;i++){
            currentNode = currentNode.next;
        }

        currentNode.data = item;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {

        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }

        if(index==0){
            removeFirst();
            return;
        }
        if(index==size){
            removeLast();
            return;
        }

        MyNode currentNode = head;

        for (int i=0; i <index; i++){
            currentNode = currentNode.next;
        }
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode currentNode = head;

        for(int i =0; i<size;i++){
            if(currentNode.data.equals(object)){
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {

        MyNode currentNode= tail;

        for(int i =size-1;i>=0;i--){
            if(currentNode.data.equals(object)){
            return i;}
            currentNode = currentNode.next;

        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {

        MyNode currentNode = head;

        for(int i =0; i<size;i++){
            if(currentNode.data.equals(object)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {

        Object [] toArr = new Object[size];

        MyNode currentNode = head;

        for (int i=0;i<size;i++){

            toArr[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return toArr;

    }

    @Override
    public void clear() {

        head = null;
        tail = null;
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


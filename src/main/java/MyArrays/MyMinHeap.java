package MyArrays;
import java.util.NoSuchElementException;

public class MyMinHeap <T extends Comparable<T>>{
    private MyArrayList<T> list = new MyArrayList<>();

    public void insert(T item) {
        list.addLast(item);
        heapifyUp(list.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) throw new NoSuchElementException();
        T min = list.getFirst();

        // move last element to top, then remove last
        list.set(0, list.getLast());
        list.removeLast();

        heapifyDown(0);
        return min;
    }

    public T getMin() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.getFirst();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                // child is smaller than parent — swap
                T temp = list.get(index);
                list.set(index, list.get(parentIndex));
                list.set(parentIndex, temp);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (index < list.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                // swap with smallest child
                T temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                index = smallest;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

}

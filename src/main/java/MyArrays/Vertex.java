package MyArrays;

import java.util.HashMap;

public class Vertex<V> implements Comparable<Vertex<V>> {

    private V data;
    private HashMap<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public V getData() {
        return data;
    }

    public HashMap<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public int compareTo(Vertex<V> other) {
        return this.toString().compareTo(other.toString());
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
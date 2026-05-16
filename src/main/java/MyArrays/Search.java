package MyArrays;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Search<V> {

    protected Vertex<V> start;
    protected HashSet<Vertex<V>> visited;
    protected HashMap<Vertex<V>, Vertex<V>> edgeTo;

    public Search(Vertex<V> start) {
        this.start = start;
        visited = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> dest) {
        return visited.contains(dest);
    }

    public MyArrayList<Vertex<V>> pathTo(Vertex<V> dest) {
        if (!hasPathTo(dest)) {
            return null;
        }

        // walk backwards from dest to start using edgeTo
        MyArrayList<Vertex<V>> path = new MyArrayList<>();
        Vertex<V> current = dest;

        while (current != start) {
            path.add(0, current); // insert at front
            current = edgeTo.get(current);
        }
        path.add(0, start);

        return path;
    }
}
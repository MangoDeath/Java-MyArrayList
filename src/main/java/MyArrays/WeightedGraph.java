package MyArrays;

import java.util.HashMap;

public class WeightedGraph<V> {

    private HashMap<V, Vertex<V>> map;
    private boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        map = new HashMap<>();
    }

    public void addVertex(V data) {
        Vertex<V> vertex = new Vertex<>(data);
        map.put(data, vertex);
    }

    public void addEdge(V sourceData, V destData, double weight) {
        // if vertex doesn't exist yet, create it
        if (!map.containsKey(sourceData)) {
            addVertex(sourceData);
        }
        if (!map.containsKey(destData)) {
            addVertex(destData);
        }

        Vertex<V> source = map.get(sourceData);
        Vertex<V> dest = map.get(destData);

        source.addAdjacentVertex(dest, weight);

        // if undirected, add the edge both ways
        if (undirected) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }

    public HashMap<V, Vertex<V>> getMap() {
        return map;
    }
}
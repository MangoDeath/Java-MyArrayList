package MyArrays;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(start);
        bfs(start);
    }

    private void bfs(Vertex<V> start) {

        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            Vertex<V> current = queue.poll();

            // go through all neighbors of current vertex
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
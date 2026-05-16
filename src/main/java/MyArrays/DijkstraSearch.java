package MyArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {

    private HashMap<Vertex<V>, Double> distances;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(start);
        distances = new HashMap<>();
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph<V> graph, Vertex<V> start) {

        // set every vertex distance to infinity at the beginning
        for (Vertex<V> v : graph.getMap().values()) {
            distances.put(v, Double.MAX_VALUE);
        }

        // distance from start to start is 0
        distances.put(start, 0.0);
        visited.add(start);

        // priority queue - smallest distance comes out first
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(distances.get(a), distances.get(b))
        );
        pq.add(start);

        while (!pq.isEmpty()) {

            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double edgeWeight = entry.getValue();

                double newDist = distances.get(current) + edgeWeight;

                // found a shorter path to neighbor
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    visited.add(neighbor);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<V> dest) {
        if (!distances.containsKey(dest)) {
            return Double.MAX_VALUE;
        }
        return distances.get(dest);
    }
}
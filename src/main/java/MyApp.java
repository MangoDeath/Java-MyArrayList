import MyArrays.*;

import java.util.LinkedList;

public class MyApp {
public static void main(String[] args){


WeightedGraph<Integer> graph = new WeightedGraph<>(true);
    graph.addEdge(1, 2, 4.0);
    graph.addEdge(1, 3, 2.0);
    graph.addEdge(2, 4, 5.0);
    graph.addEdge(3, 4, 1.0);
    graph.addEdge(4, 5, 3.0);


    Vertex<Integer> start = graph.getVertex(1);
    Vertex<Integer> end   = graph.getVertex(5);

    System.out.println("______BSF__________");

    BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(graph, start);


    System.out.println("Has path from 1 to 5: " + bfs.hasPathTo(end));


    MyArrayList<Vertex<Integer>> bfsPath = bfs.pathTo(end);
    System.out.print("Path: ");
    for (int i = 0; i < bfsPath.size(); i++) {
        System.out.print(bfsPath.get(i).getData());
        if (i < bfsPath.size() - 1) {
            System.out.print(" -> ");
        }
    }
    System.out.println();


    System.out.println("\n===== Dijkstra =====");

    DijkstraSearch<Integer> dijkstra = new DijkstraSearch<>(graph, start);

    System.out.println("Has path from 1 to 5: " + dijkstra.hasPathTo(end));
    System.out.println("Shortest distance 1 -> 5: " + dijkstra.distanceTo(end));

    MyArrayList<Vertex<Integer>> dijkstraPath = dijkstra.pathTo(end);
    System.out.print("Path: ");
    for (int i = 0; i < dijkstraPath.size(); i++) {
        System.out.print(dijkstraPath.get(i).getData());
        if (i < dijkstraPath.size() - 1) {
            System.out.print(" -> ");
        }
    }
    System.out.println();





}
}

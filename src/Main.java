import java.util.List;


public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("C", "D", 1);

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsPath = bfs.findPath("A", "D");
        System.out.println("BFS Path:");
        bfsPath.forEach(v -> System.out.print(v + " "));

        System.out.println();

        Search<String> dijkstra = new DijkstraSearch<>(graph);
        List<Vertex<String>> dijkstraPath = dijkstra.findPath("A", "D");
        System.out.println("Dijkstra Path:");
        dijkstraPath.forEach(v -> System.out.print(v + " "));
    }
}

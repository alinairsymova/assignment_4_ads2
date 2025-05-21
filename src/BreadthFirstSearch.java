import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public List<Vertex<V>> findPath(V start, V end) {
        Vertex<V> startVertex = graph.getVertex(start);
        Vertex<V> endVertex = graph.getVertex(end);

        if (startVertex == null || endVertex == null) return Collections.emptyList();

        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(endVertex)) {
                return buildPath(parentMap, endVertex);
            }

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Vertex<V>> buildPath(Map<Vertex<V>, Vertex<V>> parentMap, Vertex<V> endVertex) {
        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> current = endVertex;
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}


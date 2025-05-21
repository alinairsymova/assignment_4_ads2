import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public List<Vertex<V>> findPath(V start, V end) {
        Vertex<V> startVertex = graph.getVertex(start);
        Vertex<V> endVertex = graph.getVertex(end);

        if (startVertex == null || endVertex == null) return Collections.emptyList();

        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parentMap = new HashMap<>();
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex<V>> visited = new HashSet<>();

        for (Vertex<V> v : graph.getVertices().values()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);
        pq.add(startVertex);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            if (!visited.add(current)) continue; // already visited

            if (current.equals(endVertex)) break;

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();

                double newDist = distances.get(current) + weight;
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    parentMap.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }


        if (!parentMap.containsKey(endVertex) && !startVertex.equals(endVertex)) {
            return Collections.emptyList();
        }
        return buildPath(parentMap, endVertex);
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

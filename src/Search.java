import java.util.List;


public abstract class Search<V> {
    protected WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public abstract List<Vertex<V>> findPath(V start, V end);
}

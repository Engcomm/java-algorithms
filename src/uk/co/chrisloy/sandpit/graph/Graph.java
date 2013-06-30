package uk.co.chrisloy.sandpit.graph;

/**
 * Base interface for representing graph structures, where a set of
 * objects <T> are connected to each other via a limited set of edges.
 * 
 * There are sub-interfaces which annotate whether the graph is directed
 * (such that defined edges between vertices are unidirectional) or
 * undirected (where all edges can be traversed in both directions).
 * 
 * @author Chris Loy
 *
 * @param <T>
 */
public interface Graph<T> {
    
    public Vertex<T> getVertex(T t);
    
    public Edge<T>[] getAdjacentEdges(T t);
    
    /**
     * Returns the edge between the two specified vertices, or
     * null if no direct edge exists.
     * 
     * @param from
     * @param to
     * @return
     */
    public Edge<T> getEdge(T from, T to);
    
    public int size();
}

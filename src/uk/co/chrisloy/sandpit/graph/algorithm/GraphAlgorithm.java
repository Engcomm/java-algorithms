package uk.co.chrisloy.sandpit.graph.algorithm;

import uk.co.chrisloy.sandpit.Stack;
import uk.co.chrisloy.sandpit.graph.Graph;

/**
 * Interface for general graph algorithms capable of traversing
 * a graph.
 * 
 * @author Chris Loy
 */
public interface GraphAlgorithm {
    
    /**
     * Returns a boolean indicating whether a path exists in the 
     * given graph between the two vertices.
     * 
     * @param <T>
     * @param graph
     * @param from
     * @param to
     * @return
     */
    <T> boolean containsPath(Graph<T> graph, T from, T to);
    
    /**
     * Gets the distance between the two vertices in the given graph,
     * as a sum of the edge weights between each corresponding vertex
     * in the path found between the two nodes (which may or may not
     * be the shortest path, dependent upon algorithm correctness).
     * 
     * @param <T>
     * @param graph
     * @param from
     * @param to
     * @return
     * @throws NoValidPathException If no path exists.
     */
    <T> double getCost(Graph<T> graph, T from, T to) throws NoValidPathException;
    
    /**
     * Gets a path between the two given nodes. This may or may not
     * be the shortest available path, dependent upon the algorithm's
     * implementation and the graph complexity.
     * 
     * @param <T>
     * @param graph
     * @param from
     * @param to
     * @return
     * @throws NoValidPathException If no path exists.
     */
    <T> Stack<T> getPath(Graph<T> graph, T from, T to) throws NoValidPathException;
    
    /**
     * Exception which may be thrown from graph algorithm methods which
     * indicates that no path exists between two given nodes where the
     * calling of the method assumed that such a path existed. For
     * example if called upon to find the shortest path between two
     * unconnected vertices.
     * 
     * @author Chris Loy
     */
    public class NoValidPathException extends Exception {
        private static final long serialVersionUID = 1L;
    }
}

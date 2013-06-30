package uk.co.chrisloy.sandpit.graph.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import uk.co.chrisloy.sandpit.graph.DirectedAdjacencyListGraph;
import uk.co.chrisloy.sandpit.graph.Graph;
import uk.co.chrisloy.sandpit.graph.algorithm.GraphAlgorithm.NoValidPathException;

public class GraphAlgorithmTest {
    
    private static final Map<Integer, Collection<Integer>> MAP = new HashMap<Integer, Collection<Integer>>() {
        private static final long serialVersionUID = 1L;
        {
            put(1, Arrays.asList(2, 4));
            put(2, Arrays.asList(5));
            put(3, Arrays.asList(6, 5));
            put(4, Arrays.asList(2));
            put(5, Arrays.asList(4));
            put(6, Arrays.asList(6));
        }
    };
    
    
    @Test
    public void testBFS() throws NoValidPathException {
        Graph<Integer> g = new DirectedAdjacencyListGraph<Integer>(MAP);
        check(new BreadthFirstSearch(), g);
        check(new DepthFirstSearch(), g);
    }
    
    private void check(GraphAlgorithm algo, Graph<Integer> graph) throws NoValidPathException {
        checkContains(algo, graph);
        checkCost(algo, graph);
        checkPath(algo, graph);
    }
    
    private void checkContains(GraphAlgorithm algo, Graph<Integer> graph) throws NoValidPathException {
        assertEquals(algo.containsPath(graph, 1, 1), true);
        assertEquals(algo.containsPath(graph, 1, 2), true);
        assertEquals(algo.containsPath(graph, 1, 3), false);
        assertEquals(algo.containsPath(graph, 1, 4), true);
        assertEquals(algo.containsPath(graph, 1, 5), true);
        assertEquals(algo.containsPath(graph, 1, 6), false);
        assertEquals(algo.containsPath(graph, 2, 1), false);
        assertEquals(algo.containsPath(graph, 2, 2), true);
        assertEquals(algo.containsPath(graph, 2, 3), false);
        assertEquals(algo.containsPath(graph, 2, 4), true);
        assertEquals(algo.containsPath(graph, 2, 5), true);
        assertEquals(algo.containsPath(graph, 2, 6), false);
        assertEquals(algo.containsPath(graph, 3, 1), false);
        assertEquals(algo.containsPath(graph, 3, 2), true);
        assertEquals(algo.containsPath(graph, 3, 3), true);
        assertEquals(algo.containsPath(graph, 3, 4), true);
        assertEquals(algo.containsPath(graph, 3, 5), true);
        assertEquals(algo.containsPath(graph, 3, 6), true);
        assertEquals(algo.containsPath(graph, 4, 1), false);
        assertEquals(algo.containsPath(graph, 4, 2), true);
        assertEquals(algo.containsPath(graph, 4, 3), false);
        assertEquals(algo.containsPath(graph, 4, 4), true);
        assertEquals(algo.containsPath(graph, 4, 5), true);
        assertEquals(algo.containsPath(graph, 4, 6), false);
        assertEquals(algo.containsPath(graph, 5, 1), false);
        assertEquals(algo.containsPath(graph, 5, 2), true);
        assertEquals(algo.containsPath(graph, 5, 3), false);
        assertEquals(algo.containsPath(graph, 5, 4), true);
        assertEquals(algo.containsPath(graph, 5, 5), true);
        assertEquals(algo.containsPath(graph, 5, 6), false);
        assertEquals(algo.containsPath(graph, 6, 1), false);
        assertEquals(algo.containsPath(graph, 6, 2), false);
        assertEquals(algo.containsPath(graph, 6, 3), false);
        assertEquals(algo.containsPath(graph, 6, 4), false);
        assertEquals(algo.containsPath(graph, 6, 5), false);
        assertEquals(algo.containsPath(graph, 6, 6), true);
    }
    
    private void checkCost(GraphAlgorithm algo, Graph<Integer> graph) throws NoValidPathException {
        checkCost(algo.getCost(graph, 1, 1), 0);
        checkCost(algo.getCost(graph, 1, 2), 1);
        checkCost(algo.getCost(graph, 1, 4), 1);
        checkCost(algo.getCost(graph, 1, 5), 2, 3);
        checkCost(algo.getCost(graph, 2, 2), 0);
        checkCost(algo.getCost(graph, 2, 4), 2);
        checkCost(algo.getCost(graph, 2, 5), 1);
        checkCost(algo.getCost(graph, 3, 2), 3);
        checkCost(algo.getCost(graph, 3, 3), 0);
        checkCost(algo.getCost(graph, 3, 4), 2);
        checkCost(algo.getCost(graph, 3, 5), 1);
        checkCost(algo.getCost(graph, 3, 6), 1);
        checkCost(algo.getCost(graph, 4, 2), 1);
        checkCost(algo.getCost(graph, 4, 4), 0);
        checkCost(algo.getCost(graph, 4, 5), 2);
        checkCost(algo.getCost(graph, 5, 2), 2);
        checkCost(algo.getCost(graph, 5, 4), 1);
        checkCost(algo.getCost(graph, 5, 5), 0);
        checkCost(algo.getCost(graph, 6, 6), 0);
    }
    
    private void checkPath(GraphAlgorithm algo, Graph<Integer> graph) throws NoValidPathException {
        checkCost(algo.getCost(graph, 1, 2), 1d);
    }
    
    /**
     * More than one possible cost due to different routes.
     * 
     * @param actual
     * @param expecteds
     */
    private void checkCost(double actual, double...expecteds) {
        for(double expected : expecteds) {
            if (Double.compare(actual, expected) == 0) {
                return;
            }
        }
        fail(actual + " not in " + Arrays.toString(expecteds));
    }
}

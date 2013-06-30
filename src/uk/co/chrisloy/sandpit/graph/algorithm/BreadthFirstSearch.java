package uk.co.chrisloy.sandpit.graph.algorithm;

import uk.co.chrisloy.sandpit.HashTable;
import uk.co.chrisloy.sandpit.LinkedQueue;
import uk.co.chrisloy.sandpit.LinkedStack;
import uk.co.chrisloy.sandpit.Queue;
import uk.co.chrisloy.sandpit.Stack;
import uk.co.chrisloy.sandpit.graph.Edge;
import uk.co.chrisloy.sandpit.graph.Graph;
import uk.co.chrisloy.sandpit.graph.Vertex;

/**
 * Graph traversal algorithm which explores local vertices first.
 * 
 * @author Chris Loy
 */
public class BreadthFirstSearch implements GraphAlgorithm {
    
    private static final int WHITE = 0;
    private static final int GREY = 1;
    private static final int BLACK = 2;
    
    /**
     * Small utility class which holds the extra meta data which can
     * be attached to each Vertex that is required by BFS.
     * 
     * @author Chris Loy
     *
     * @param <T>
     */
    private class VertexData<T> {
        int colour = WHITE;
        double cost = -1;
        Vertex<T> predecessor = null;
    }
    
    private <T> VertexData<T> bfs(HashTable<Vertex<T>, VertexData<T>> table, Graph<T> graph, T from, T to) throws NoValidPathException {
        final Vertex<T> source = graph.getVertex(from);
        data(table, source).colour = GREY;
        data(table, source).cost = 0;
        final Queue<Vertex<T>> q = new LinkedQueue<Vertex<T>>();
        q.enqueue(source);
        while (!q.isEmpty()) {
            Vertex<T> u = q.dequeue();
            if (u.getObject().equals(to)) {
                return data(table, u);
            }
            for (Edge<T> ve : graph.getAdjacentEdges(u.getObject())) {
                if (data(table, ve.getVertex()).colour == WHITE) {
                    Vertex<T> v = ve.getVertex();
                    data(table, v).colour = GREY;
                    data(table, v).cost = data(table, u).cost + ve.getCost();
                    data(table, v).predecessor = u;
                    q.enqueue(v);
                }
            }
            data(table, u).colour = BLACK;
        }
        throw new NoValidPathException();
    }
    
    private <T> VertexData<T> data(HashTable<Vertex<T>, VertexData<T>> table, Vertex<T> vertex) {
        if (!table.containsKey(vertex)) {
            table.insert(vertex, new VertexData<T>());
        }
        return table.search(vertex);
    }

    @Override
    public <T> boolean containsPath(Graph<T> graph, T from, T to) {
        try {
            final HashTable<Vertex<T>, VertexData<T>> table = new HashTable<Vertex<T>, VertexData<T>>(graph.size());
            bfs(table, graph, from, to);
            return true;
        } catch (NoValidPathException nvpe) {
            return false;
        }
    }

    @Override
    public <T> double getCost(Graph<T> graph, T from, T to) throws NoValidPathException {
        final HashTable<Vertex<T>, VertexData<T>> table = new HashTable<Vertex<T>, VertexData<T>>(graph.size());
        VertexData<T> target = bfs(table, graph, from, to);
        return target.cost;
    }

    @Override
    public <T> Stack<T> getPath(Graph<T> graph, T from, T to) throws NoValidPathException {
        final HashTable<Vertex<T>, VertexData<T>> table = new HashTable<Vertex<T>, VertexData<T>>(graph.size());
        VertexData<T> target = bfs(table, graph, from, to);
        Stack<T> path = new LinkedStack<T>();
        path.push(to);
        while (target.predecessor != null) {
            path.push(target.predecessor.getObject());
            target = data(table, target.predecessor);
        }
        return path;
    }
}

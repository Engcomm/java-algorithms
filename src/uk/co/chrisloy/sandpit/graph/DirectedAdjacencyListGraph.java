package uk.co.chrisloy.sandpit.graph;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import uk.co.chrisloy.sandpit.HashTable;

public class DirectedAdjacencyListGraph<T> implements DirectedGraph<T> {
    
    private final HashTable<T, Vertex<T>> vertices;
    
    public DirectedAdjacencyListGraph(Map<T, Collection<T>> map) {
        this.vertices = constructVertexArray(map);
    }
    
    @SuppressWarnings("unchecked")
    private HashTable<T, Vertex<T>> constructVertexArray(Map<T, Collection<T>> map) {
        int numVertices = map.size();
        HashTable<T, Vertex<T>> translate = new HashTable<T, Vertex<T>>(numVertices);
        for (T obj : map.keySet()) {
            translate.insert(obj, new Vertex<T>(obj));
        }
        HashTable<T, Vertex<T>> vertices = new HashTable<T, Vertex<T>>(numVertices);
        for (Entry<T, Collection<T>> e : map.entrySet()) {
            Vertex<T> v1 = translate.search(e.getKey());
            v1.edges = new Edge[e.getValue().size()];
            int i = 0;
            for(T neighbour : e.getValue()) {
                Vertex<T> v2 = translate.search(neighbour);
                // TODO cost hard-coded to 1 currently
                v1.edges[i++] = new Edge<T>(1, v2);
            }
            vertices.insert(v1.getObject(), v1);
        }
        return vertices;
    }

    @Override
    public Edge<T>[] getAdjacentEdges(T t) {
        Vertex<T> v = vertices.search(t);
        if (v == null) {
            return null;
        } else {
            return v.edges;
        }
    }
    
    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public Vertex<T> getVertex(T t) {
        return vertices.search(t);
    }

    @Override
    public Edge<T> getEdge(T from, T to) {
        Vertex<T> vFrom = vertices.search(from);
        for(Edge<T> edge : vFrom.edges) {
            if(edge.getVertex().getObject().equals(to)) {
                return edge;
            }
        }
        return null; // not found
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:");
        sb.append(vertices);
        return sb.toString();
    }
}

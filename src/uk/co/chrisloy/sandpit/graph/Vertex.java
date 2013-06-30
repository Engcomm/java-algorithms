package uk.co.chrisloy.sandpit.graph;

import java.util.Arrays;

public class Vertex<T> {
    
    private final T obj;
    Edge<T>[] edges;
    
    Vertex(T obj) {
        this.obj = obj;
    }
    
    public T getObject() {
        return obj;
    }
    
    @Override
    public String toString() {
        return String.valueOf(obj) + Arrays.toString(edges);
    }
}
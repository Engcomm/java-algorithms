package uk.co.chrisloy.sandpit.graph;

public class Edge<T> {
    
    private final double cost;
    private final Vertex<T> vertex;
    
    Edge(double cost, Vertex<T> vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }
    
    public double getCost() {
        return cost;
    }
    
    /**
     * The vertex reached along this edge (not the source).
     * 
     * @return
     */
    public Vertex<T> getVertex() {
        return vertex;
    }
    
    @Override
    public String toString() {
        return ">" + vertex.getObject();
    }
}
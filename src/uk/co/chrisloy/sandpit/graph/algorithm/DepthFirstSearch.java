package uk.co.chrisloy.sandpit.graph.algorithm;

import uk.co.chrisloy.sandpit.LinkedStack;
import uk.co.chrisloy.sandpit.Stack;
import uk.co.chrisloy.sandpit.graph.Edge;
import uk.co.chrisloy.sandpit.graph.Graph;

public class DepthFirstSearch implements GraphAlgorithm {

    @Override
    public <T> boolean containsPath(Graph<T> graph, T from, T to) {
        System.out.println("contains: " + from + ">" + to);
        return dfs(new LinkedStack<T>(), graph, from, to);
    }

    @Override
    public <T> double getCost(Graph<T> graph, T from, T to) throws NoValidPathException {
        Stack<T> path = new LinkedStack<T>();
        boolean pathExists = dfs(path, graph, from, to);
        if (pathExists) {
            double cost = 0;
            T curr = from;
            while(!path.isEmpty()) {
                T next = path.pop();
                cost += graph.getEdge(curr, next).getCost();
                curr = next;
            }
            return cost;
        } else {
            throw new NoValidPathException();
        }
    }

    @Override
    public <T> Stack<T> getPath(Graph<T> graph, T from, T to) throws NoValidPathException {
        Stack<T> path = new LinkedStack<T>();
        boolean pathExists = dfs(path, graph, from, to);
        if (pathExists) {
            return path;
        } else {
            throw new NoValidPathException();
        }
    }
    
    private <T> boolean dfs(Stack<T> path, Graph<T> graph, T from, T to) {
        System.out.println("from: " + from + ">" + to);
        if (path.contains(from)) {
            return false;
        } else {
            path.push(from);
        }
        if (to.equals(from)) {
            return true;
        }
        for (Edge<T> edge : graph.getAdjacentEdges(from)) {
            T next = edge.getVertex().getObject();
            if(dfs(path, graph, next, to)) {
                return true;
            }
        }
        path.pop();
        return false;
    }
}

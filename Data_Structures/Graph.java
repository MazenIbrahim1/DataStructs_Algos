package Data_Structures;

import java.util.*;
import java.util.LinkedList;

// Using a hashmap
public class Graph<T> {
    // (Vertex : List of edges)
    // E.G. (A : B, E, L, C)
    private Map<T, List<T> > map = new HashMap<>();

    // Adding a vertex to the graph starting with 0 edges
    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    // Adding an edge 
    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    // Making the default value of bidirectional = true
    public void addEdge(T source, T destination) {
        addEdge(source, destination, true);
    }

    // Vertex Count of graph size
    public int getVertexCount() {
        return map.keySet().size();
    }

    // Check if a vertex exists in the graph
    public boolean hasVertex(T vertex) {
        return map.containsKey(vertex);
    }

    // Checks if an edge between two vertices exist
    public boolean hasEdge(T src, T dest) {
        // Check if vertices exist
        if(hasVertex(src) && hasVertex(dest)) {
            return map.get(src).contains(dest) ;
        }
        return false;
    }

    // Remove a vertex from the graph
    public void removeVertex(T vertex) {
        map.remove(vertex);

        // Remove any edges pointing to this vertex from other vertices
        for (T key : map.keySet()) {
            map.get(key).remove(vertex);
        }
    }

    // Remove an edge between two vertices
    public void removeEdge(T src, T dest) {
        if(hasVertex(src) && hasVertex(dest)) {
            map.get(src).remove(dest);
        }
    }

    public static void main(String[] args) {

    }
}

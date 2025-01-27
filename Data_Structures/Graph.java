package Data_Structures;

import java.util.*;
import java.util.LinkedList;

// Using a hashmap
public class Graph<T> {
    // (Vertex : List of edges)
    // E.G. (A : B, E, L, C)
    private Map<T, List<T> > map = new HashMap<>();

    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

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

    public static void main(String[] args) {

    }
}

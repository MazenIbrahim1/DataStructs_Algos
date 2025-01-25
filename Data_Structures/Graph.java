package Data_Structures;

import java.util.*;
import java.util.LinkedList;

// Using a hashmap
public class Graph<T> {
    private Map<T, List<T> > map = new HashMap<>();

    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    public void addEdge() {
        
    }
}

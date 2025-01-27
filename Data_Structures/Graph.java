package Data_Structures;

import java.util.*;
import java.util.LinkedList;

// Using a hashmap
public class Graph<T> {
    // (Vertex : List of edges)
    // E.G. (A : B, E, L, C)
    private Map<T, List<T> > map = new HashMap<>();

    // Adding a vertex to the graph starting with 0 edges
    // O(1)
    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    // Adding an edge
    // O(1)
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
    // O(1)
    public void addEdge(T source, T destination) {
        addEdge(source, destination, true);
    }

    // Vertex Count of graph size
    public int getVertexCount() {
        return map.keySet().size();
    }

    // Check if a vertex exists in the graph
    // O(1)
    public boolean hasVertex(T vertex) {
        return map.containsKey(vertex);
    }

    // Checks if an edge between two vertices exist
    // O(1)
    public boolean hasEdge(T src, T dest) {
        // Check if vertices exist
        if(hasVertex(src) && hasVertex(dest)) {
            return map.get(src).contains(dest) ;
        }
        return false;
    }

    // Remove a vertex from the graph
    // O(n)
    public void removeVertex(T vertex) {
        map.remove(vertex);

        // Remove any edges pointing to this vertex from other vertices
        for (T key : map.keySet()) {
            map.get(key).remove(vertex);
        }
    }

    // Remove an edge between two vertices
    // O(1)
    public void removeEdge(T src, T dest) {
        if(hasVertex(src) && hasVertex(dest)) {
            map.get(src).remove(dest);
            map.get(dest).remove(src);
        }
    }

    // BFS --> Queue
    // O(V + E)
    public void bfs(T start) {
        if (!hasVertex(start)) {
            return;
        }

        Set<T> visited = new HashSet<>();
        Queue<T> queue = new Queue<>();

        visited.add(start);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            T vertex = queue.dequeue();
            System.out.print(vertex + " ");

            for (T neighbor : map.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.enqueue(neighbor);
                }
            }
        }
    }

    // DFS --> Stack
    // O(V + E)
    public void dfs(T start) {
        if (!hasVertex(start)) {
            return;
        }

        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            T vertex = stack.pop();

            if (!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.print(vertex + " ");

            for (T neighbor : map.get(vertex)) {
                if (!visited.contains(neighbor)) {
                stack.push(neighbor);
                }
            }
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();

        // Adding vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Adding edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D", false);

        // Testing vertex count
        System.out.println("Vertex count: " + graph.getVertexCount()); // Output: 4

        // Testing hasVertex
        System.out.println("Graph has vertex A: " + graph.hasVertex("A")); // Output: true
        System.out.println("Graph has vertex E: " + graph.hasVertex("E")); // Output: false

        // Testing hasEdge
        System.out.println("Graph has edge A-B: " + graph.hasEdge("A", "B")); // Output: true
        System.out.println("Graph has edge C-D: " + graph.hasEdge("C", "D")); // Output: true
        System.out.println("Graph has edge D-C: " + graph.hasEdge("D", "C")); // Output: false

        // Testing BFS
        System.out.print("BFS starting from A: ");
        graph.bfs("A"); // Output: A B C D

        // Testing DFS
        System.out.print("\nDFS starting from A: ");
        graph.dfs("A"); // Output: A B D C (or another valid DFS order)

        // Removing an edge
        graph.removeEdge("A", "B");
        System.out.println("\nGraph has edge A-B after removal: " + graph.hasEdge("A", "B")); // Output: false

        // Removing a vertex
        graph.removeVertex("D");
        System.out.println("Vertex count after removing D: " + graph.getVertexCount()); // Output: 3
        System.out.println("Graph has vertex D: " + graph.hasVertex("D")); // Output: false
    }
}

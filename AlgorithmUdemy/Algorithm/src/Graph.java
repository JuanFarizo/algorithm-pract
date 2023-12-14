import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList =
            new HashMap<>();

    public boolean addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vert1, String vert2) {
        ArrayList<String> edges1 = adjList.get(vert1);
        ArrayList<String> edges2 = adjList.get(vert2);
        if (edges1 != null && edges2 != null) {
            edges1.add(vert2);
            edges2.add(vert1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vert1, String vert2) {
        ArrayList<String> edges1 = adjList.get(vert1);
        ArrayList<String> edges2 = adjList.get(vert2);
        if (edges1 != null && edges2 != null) {
            edges1.remove(vert2);
            edges2.remove(vert1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        ArrayList<String> edges = adjList.get(vertex);
        if (edges != null) {
            for (String adjVertex : edges) {
                adjList.get(adjVertex).remove(vertex);
            }
            adjList.remove(vertex);
            return true;
        }
        return false;
    }
}

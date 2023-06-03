import java.util.*;

public class AdjacencyListGraph
{
    // creat e hashmap object to hold the Adjacency List
    private HashMap<Integer, ArrayList<Integer>> adjList;

    // constructor to create a directed graph object.
    public AdjacencyListGraph ()
    {
        adjList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex)
    {
        if (!adjList.containsKey(vertex))
        {
            adjList.put(vertex, new ArrayList<>());
        }
    }

    // Method to add an edge between two vertices in the graph
    public void addEdge(int from, int to)
    {
        // Check that the edge does not connect a vertex to itself
        if (from != to)
        {
            // Add the vertices to the graph if they are not already present
            addVertex(from);
            addVertex(to);
            // Add the edge to the adjacency list of the 'from' vertex
            adjList.get(from).add(to);
        }else
        {
            System.out.println("The Edge specified  in the graphVertexAndEdge.txt From: "+ from + " To: " + to + " is not valid");
        }
    }

    // Method to remove a vertex from the graph
    public void removeVertex(int vertex)
    {
        if (adjList.containsKey(vertex))
        {
            adjList.remove(vertex);
        }
    }

    // Method to get the number of vertices in the graph
    public int getNumVertices()
    {
        return adjList.size();
    }

    // Method to get the neighbors of a vertex in the graph
    public List<Integer> getNeighbors(int vertex)
    {
        if (adjList.containsKey(vertex))
        {
            return adjList.get(vertex);
        }
        return new ArrayList<>();
    }

    // Method to get an array of the vertices in the graph
    public int[] getVertices()
    {
        return adjList.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    // Method to get a list of the edges in the graph
    public List<List<Integer>> getEdges()
    {
        List<List<Integer>> edges = new ArrayList<>();
        for (Map.Entry< Integer, ArrayList<Integer> > entry : adjList.entrySet())
        {
            int source = entry.getKey();
            List<Integer> neighbors = entry.getValue();
            for (int neighbor : neighbors)
            {
                edges.add(Arrays.asList(source, neighbor));
            }
        }
        return edges;
    }

    // Method to get the adjacency list representation of the graph as a string
    public String getAdjacencyList()
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : adjList.entrySet())
        {
            Integer vertex = entry.getKey();
            ArrayList<Integer> neighbors = entry.getValue();
            sb.append(vertex).append(": ");
            for (Integer neighbor : neighbors)
            {
                sb.append(neighbor).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
import java.io.FileNotFoundException;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException
    {
        // Creating a new DirectedGraph object by parsing a file
        AdjacencyListGraph dg = GraphFileParser.parse("src/GraphDetails.txt");

        // Printing the number of vertices in the graph and its edges to the console
        System.out.println("Amount of Vertices : " + dg.getNumVertices());
        List<List<Integer>> edges = dg.getEdges();
        if (edges.isEmpty()){
            System.out.println("The graph contains no edges\n");
        }else {
            System.out.println("Graph Edges are : " + dg.getEdges() + "\n");
        }
        String adjacencyList = dg.getAdjacencyList();
        if (adjacencyList.isEmpty()){
            System.out.println("Empty Adjacency list   ");
        }else {
            // Printing the adjacency list of the graph to the console
            System.out.println("Adjacency List : \n" + dg.getAdjacencyList());
        }

        if (dg.getNumVertices() == 0)
        {
            System.out.println("The graph is empty, Cannot identify the graph is 'Cyclic' or the 'Acyclic'");
        }
        else {
            // Checking if the graph is acyclic using the AcyclicGraphChecker class
            if(AcyclicEncounter.isCyclicGraph(dg))
                System.out.println("\nGraph is Acyclic ");
            else
                System.out.println("\nGraph is cyclic  ");
        }

        // Printing a separator to the console
        System.out.println("******");
    }
}
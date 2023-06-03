import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphFileParser
{
    public static AdjacencyListGraph parse(String filename) throws FileNotFoundException
    {
        // Creating a new DirectedGraph object to store the graph data
        AdjacencyListGraph graph = new AdjacencyListGraph();

        // Creating a new Scanner object to read from the file
        Scanner scanner = new Scanner(new File(filename));

        // Printing a separator to the console
        System.out.println("******");
        System.out.println("Retrieved Graph Data: ");

        while (scanner.hasNextLine())
        {

            String line = scanner.nextLine();

            String[] tokens = line.split("   ");


            if (tokens.length != 2)
            {
                continue;
            }

            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);


            System.out.println(from + " --> "+ to);

            graph.addEdge(from, to);
        }
        System.out.println();

        scanner.close();

        return graph;
    }
}
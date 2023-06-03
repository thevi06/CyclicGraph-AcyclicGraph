import java.util.*;

/**
 * Name: Thevindu Dilmith
 * IIT ID: 20210197
 */
public class AcyclicEncounter
{
    public static boolean isCyclicGraph(AdjacencyListGraph graph)
    {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentStack = new HashSet<>();
        List<Integer> cycle = new ArrayList<>();


        for (int vertex : graph.getVertices())
        {

            if (!visited.contains(vertex))
            {

                if (detectCycleInGraphUsingDFS(vertex, visited, currentStack, graph, cycle))
                {
                    cycle.add(vertex);
                    Collections.reverse(cycle);
                    int startIndex = cycle.indexOf(cycle.get(cycle.size() - 1));
                    List<Integer> subCycle = cycle.subList(startIndex, cycle.size());
                    System.out.print("\nCycle detected: ");
                    for (int i = 0; i < subCycle.size(); i++)
                    {
                        System.out.print(subCycle.get(i));
                        if (i != subCycle.size() - 1)
                        {
                            System.out.print(" -> ");
                        }
                    }
                    System.out.println();
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Detects cycles in a directed graph using a depth-first search as a support function for the isAcyclic method.
     * @param vertex the vertex now being examined
     * @param visited a collection of accessed vertices
     * @param currentStack a group of the recursive call stack's active vertices
     * @param graph cycles are being searched in the directed graph.
     * @param cycle the vertices of any cycle that is discovered will be added to a list.
     * @return true If a cycle is found, true; otherwise, false
     */
    private static boolean detectCycleInGraphUsingDFS(int vertex, Set<Integer> visited, Set<Integer> currentStack, AdjacencyListGraph graph, List<Integer> cycle)
    {
        visited.add(vertex);
        currentStack.add(vertex);
        System.out.println("Visiting vertex " + vertex + " (adding it to the visited set and current stack)");

        for (int neighbor : graph.getNeighbors(vertex))
        {
            if (!visited.contains(neighbor))
            {
                System.out.println("  Vertex " + neighbor + " is not visited yet, recursively visiting it");
                if (detectCycleInGraphUsingDFS(neighbor, visited, currentStack, graph, cycle))
                {
                    cycle.add(neighbor);
                    System.out.println("  Detected cycle involving vertex " + neighbor + " (adding it to the cycle list)");
                    return true;
                }
            }
            else if (currentStack.contains(neighbor))
            {
                cycle.add(neighbor);
                System.out.println("  Detected cycle involving vertex " + neighbor + " (adding it to the cycle list)");
                return true;
            }
            else
            {
                System.out.println("  Vertex " + neighbor + " is not currently in the stack and has already been visited.");
            }
        }

        currentStack.remove(vertex);
        System.out.println("Removing vertex " + vertex + " from the current stack");
        return false;
    }
}

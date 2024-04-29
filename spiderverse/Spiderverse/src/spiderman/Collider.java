package spiderman;


import java.util.ArrayList;
import java.util.List;


/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * DimensionInputFile name is passed through the command line as args[0]
 * Read from the DimensionsInputFile with the format:
 * 1. The first line with three numbers:
 *      i.    a (int): number of dimensions in the graph
 *      ii.   b (int): the initial size of the cluster table prior to rehashing
 *      iii.  c (double): the capacity(threshold) used to rehash the cluster table 
 * 2. a lines, each with:
 *      i.    The dimension number (int)
 *      ii.   The number of canon events for the dimension (int)
 *      iii.  The dimension weight (int)
 * 
 * Step 2:
 * SpiderverseInputFile name is passed through the command line as args[1]
 * Read from the SpiderverseInputFile with the format:
 * 1. d (int): number of people in the file
 * 2. d lines, each with:
 *      i.    The dimension they are currently at (int)
 *      ii.   The name of the person (String)
 *      iii.  The dimensional signature of the person (int)
 * 
 * Step 3:
 * ColliderOutputFile name is passed in through the command line as args[2]
 * Output to ColliderOutputFile with the format:
 * 1. e lines, each with a different dimension number, then listing
 *       all of the dimension numbers connected to that dimension (space separated)
 * 
 * @author Seth Kelley
 */

public class Collider {

    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println(
                "Execute: java -cp bin spiderman.Collider <dimension INput file> <spiderverse INput file> <collider OUTput file>");
                return;
        }

        // WRITE YOUR CODE HERE
      
        String dimensionsInputFile = args[0];
        String spiderverseInputFile = args[1];
        String outputFile = args[2];

        // Create and populate the cluster table
        ClusterTable clusterTable = readDimensionsInput(dimensionsInputFile);

        // Connect clusters
        clusterTable.connectClusters();

        // Create adjacency list
        AdjacencyList adjacencyList = createAdjacencyList(clusterTable);

        // Read people from spiderverse input file
        Spiderverse spiderverse = readSpiderverseInput(spiderverseInputFile);

        // Write adjacency list to output file
        adjacencyList.writeToOutputFile(outputFile);
    }

    /**
     * Reads dimension input from a file and constructs a cluster table.
     * 
     * @param fileName the name of the dimension input file
     * @return the constructed cluster table
     */
    public static ClusterTable readDimensionsInput(String fileName) {
        ClusterTable clusterTable = null;
    StdIn.setFile(fileName); // Set the file for StdIn
    int numDimensions = StdIn.readInt(); // Read numDimensions using StdIn
    int initialSize = StdIn.readInt(); // Read initialSize using StdIn
    double threshold = StdIn.readDouble(); // Read threshold using StdIn
    clusterTable = new ClusterTable(initialSize, threshold);
    StdIn.readLine(); // consume newline

    for (int i = 0; i < numDimensions; i++) {
        int dimensionNumber = StdIn.readInt(); // Read dimensionNumber using StdIn
        int numCanonEvents = StdIn.readInt(); // Read numCanonEvents using StdIn
        int dimensionWeight = StdIn.readInt(); // Read dimensionWeight using StdIn
        clusterTable.addDimensionToCluster(dimensionNumber, numCanonEvents, dimensionWeight);
    }
         
        return clusterTable;
}

    /**
     * Reads Spiderverse input from a file and constructs a Spiderverse object.
     * 
     * @param fileName the name of the Spiderverse input file
     * @return the constructed Spiderverse object
     */
    public static Spiderverse readSpiderverseInput(String fileName) {
        Spiderverse spiderverse = new Spiderverse();
        spiderverse.readSpiderverseFile(fileName);
        return spiderverse;
    }

    /**
     * Creates an adjacency list based on the given cluster table.
     * 
     * @param clusterTable the cluster table to create the adjacency list from
     * @return the constructed adjacency list
     */
    public static AdjacencyList createAdjacencyList(ClusterTable clusterTable) {
        AdjacencyList adjacencyList = new AdjacencyList();
        // Add edges based on clusters
        List<List<Integer>> clusters = clusterTable.getClusters();
        for (List<Integer> cluster : clusters) {
            int firstDimension = cluster.get(0); // Get the first dimension in the cluster
            // Link the first dimension to every other dimension in the cluster
            for (int i = 1; i < cluster.size(); i++) {
                int dimension = cluster.get(i);
                adjacencyList.addEdge(firstDimension, dimension);
                adjacencyList.addEdge(dimension, firstDimension); // Add the reverse edge for undirected connection
            }
        }
        return adjacencyList;
    }
}
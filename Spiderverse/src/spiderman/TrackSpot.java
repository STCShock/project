package spiderman;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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
 * SpotInputFile name is passed through the command line as args[2]
 * Read from the SpotInputFile with the format:
 * Two integers (line seperated)
 *      i.    Line one: The starting dimension of Spot (int)
 *      ii.   Line two: The dimension Spot wants to go to (int)
 * 
 * Step 4:
 * TrackSpotOutputFile name is passed in through the command line as args[3]
 * Output to TrackSpotOutputFile with the format:
 * 1. One line, listing the dimenstional number of each dimension Spot has visited (space separated)
 * 
 * @author Seth Kelley
 */

public class TrackSpot {
    
    public static void main(String[] args) {

        if ( args.length < 4 ) {
            StdOut.println(
                "Execute: java -cp bin spiderman.TrackSpot <dimension INput file> <spiderverse INput file> <spot INput file> <trackspot OUTput file>");
                return;
        }

        // WRITE YOUR CODE HERE
        String dimensionInputFile = args[0];
        String spiderverseInputFile = args[1];
        String spotInputFile = args[2];
        String trackSpotOutputFile = args[3];

        // Step 1: Read from the DimensionInputFile
        StdIn.setFile(dimensionInputFile);
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        double c = StdIn.readDouble();
        for (int i = 0; i < a; i++) {
            int dimensionNumber = StdIn.readInt();
            int canonEvents = StdIn.readInt();
            int dimensionWeight = StdIn.readInt();
        }

        // Step 2: Read from the SpiderverseInputFile
        StdIn.setFile(spiderverseInputFile);
        int d = StdIn.readInt();
        for (int i = 0; i < d; i++) {
            int currentDimension = StdIn.readInt();
            String personName = StdIn.readString();
            int dimensionalSignature = StdIn.readInt();
        }

        // Step 3: Read from the SpotInputFile
        StdIn.setFile(spotInputFile);
        int startDimension = StdIn.readInt();
        int endDimension = StdIn.readInt();

        // Step 4: Output to TrackSpotOutputFile
        StdOut.setFile(trackSpotOutputFile);
        
        //make list
        ClusterTable clusterTable = readDimensionsInput( dimensionInputFile);
        AdjacencyList adjacencyList = createAdjacencyList(clusterTable);
      trackSpotOutputFile(startDimension,endDimension,adjacencyList);
    }
    
 //________________________________COPIED CODE FROM OTHER FILE DO NOT CHANGE____________________________
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
            
        }
    }
    return adjacencyList;
}
        
     
       // ________________________________END OF COPIED CODE DO NOT CHANGE ABOVE ____________________________________
    
    
    // TRACK AND PRINT DIMENSIONS
    private static void trackSpotOutputFile(int startDimension, int endDimension, AdjacencyList adjacencyList) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(startDimension);
    
        while (!stack.isEmpty()) {
            int currentDimension = stack.pop();
    
            if (visited.contains(currentDimension)) {
                continue;
            }
    
            visited.add(currentDimension);
    
            StdOut.print(currentDimension + " ");
    
            List<Integer> neighbors = adjacencyList.getNeighbors(currentDimension);
            
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    
        // Print the end dimension if it's visited
        if (visited.contains(endDimension)) {
            StdOut.print(endDimension);
        }
        StdOut.print(endDimension); // output end file
    }

        
    }
    



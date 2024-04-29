package spiderman;

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
 * 
 * Step 2:
 * ClusterOutputFile name is passed in through the command line as args[1]
 * Output to ClusterOutputFile with the format:
 * 1. n lines, listing all of the dimension numbers connected to 
 *    that dimension in order (space separated)
 *    n is the size of the cluster table.
 * 
 * @author Seth Kelley
 */

public class Clusters {

    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println(
                "Execute: java -cp bin spiderman.Clusters <dimension INput file> <collider OUTput file>");
                return;
        }

        // WRITE YOUR CODE HERE 
     // Extract input and output file names from command-line arguments
     String dimensionInputFile = args[0];
     String clusterOutputFile = args[1];

     try {
         // Populate the cluster table with data from the input file
         ClusterTable clusterTable = populateClusterTable(dimensionInputFile);
         // Connect dimensions between different clusters
         clusterTable.connectDimensionsBetweenClusters();
         // Set the output file for writing the cluster table
         StdOut.setFile(clusterOutputFile);
         // Output the cluster table to the specified output file
         clusterTable.printClusterTable();
     } catch (Exception e) {
         // Handle any exceptions and print error message
         System.err.println("Error: " + e.getMessage());
     }
 }

 // Method to populate the cluster table with data from the input file
 private static ClusterTable populateClusterTable(String dimensionInputFile) throws Exception {
     // Set the input file for reading
     StdIn.setFile(dimensionInputFile);
     // Read metadata from the input file
     int numDimensions = StdIn.readInt();
     int initialSize = StdIn.readInt();
     double capacity = StdIn.readDouble();
     // Create a new cluster table with the specified initial size and capacity
     ClusterTable clusterTable = new ClusterTable(initialSize, capacity);

     // Read dimension data from the input file and add to the cluster table
     for (int i = 0; i < numDimensions; i++) {
         int dimensionNumber = StdIn.readInt();
         int canonEvents = StdIn.readInt();
         int dimensionWeight = StdIn.readInt();
         clusterTable.addDimensionToCluster(dimensionNumber, canonEvents, dimensionWeight);
     }

     // Return the populated cluster table
     return clusterTable;
 }
 // THE CODE ABOVE THIS WORKS DONT TOUCH.

}
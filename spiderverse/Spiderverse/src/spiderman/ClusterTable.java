package spiderman;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ClusterTable {

    private int size; // Current size of the cluster table
    private int totalDimensions; // Total number of dimensions stored in the cluster table
    private double capacity; // Capacity threshold for rehashing
    private List<List<Integer>> clusters; // List of clusters

    // Constructor
    public ClusterTable(int initialSize, double capacity) {
        // Initialize instance variables
        this.size = initialSize;
        this.capacity = capacity;
        this.totalDimensions = 0;
        this.clusters = new ArrayList<>(initialSize);
        // Initialize clusters list with empty lists
        for (int i = 0; i < initialSize; i++) {
            this.clusters.add(new ArrayList<>());
        }
    }

    // Add a dimension to the cluster
    public void addDimensionToCluster(int dimensionNumber, int canonEvents, int dimensionWeight) {
        // Check if rehashing is needed based on load factor
        if ((double) totalDimensions / size >= capacity) {
            rehash();
        }
        // Calculate cluster index for the dimension
        int clusterIndex = dimensionNumber % size;
        // Add dimension to the cluster
        clusters.get(clusterIndex).add(0, dimensionNumber);

        // Increment total dimensions count
        totalDimensions++;
    }

    // Perform rehashing
    private void rehash() {
        // Calculate new size for the cluster table
        int newSize = size * 2;
        // Create a new list to hold clusters with the new size
        List<List<Integer>> newClusters = new ArrayList<>(newSize);
        // Initialize new clusters list with empty lists
        for (int i = 0; i < newSize; i++) {
            newClusters.add(new ArrayList<>());
        }
        // Rehash dimensions to the new cluster table
        for (List<Integer> cluster : clusters) {
            for (int dimensionNumber : cluster) {
                int newIndex = dimensionNumber % newSize;
                newClusters.get(newIndex).add(0, dimensionNumber);
            }
        }
        // Update the size and clusters list with the new values
        size = newSize;
        clusters = newClusters;
    }

    // Connect dimensions between different clusters
    public void connectDimensionsBetweenClusters() {
        int numClusters = clusters.size();

        // Wrap around the "previous" clusters for the first two clusters
        for (int i = 0; i < 2; i++) {
            List<Integer> currentCluster = clusters.get(i);
            List<Integer> prevCluster = clusters.get((i - 1 + numClusters) % numClusters);
            List<Integer> prevPrevCluster = clusters.get((i - 2 + numClusters) % numClusters);
            currentCluster.add(prevCluster.get(0));
            currentCluster.add(prevPrevCluster.get(0));
        }

        // For other clusters, add the first dimension of the previous two clusters to the end of the current cluster
        for (int i = 2; i < numClusters; i++) {
            List<Integer> currentCluster = clusters.get(i);
            List<Integer> prevCluster = clusters.get(i - 1);
            List<Integer> prevPrevCluster = clusters.get(i - 2);
            currentCluster.add(prevCluster.get(0));
            currentCluster.add(prevPrevCluster.get(0));
        }
    }

    // Print the cluster table
    public void printClusterTable() {
        // Iterate through each cluster and print its dimensions
        for (int i = 0; i < size; i++) {
            for (int dimensionNumber : clusters.get(i)) {
                StdOut.print(dimensionNumber + " ");
            }
            StdOut.println();
        }
    }

    // Keep the note here

    // THE CODE ABOVE THIS WORKS DONT TOUCH
   
    // Keep the new methods below this comment

    public List<Integer> getConnectedDimensions(int dimension) {
        int clusterIndex = dimension % size;
        return clusters.get(clusterIndex);
    }

   

    // Read people from spiderverse input file and add them to corresponding dimensions
    public void addPeopleFromSpiderverse(String fileName) {
        StdIn.setFile(fileName); // Set the file for StdIn
        int numPeople = StdIn.readInt(); // Read numPeople using StdIn
        StdIn.readLine(); // consume newline
    
        for (int i = 0; i < numPeople; i++) {
            int dimension = StdIn.readInt(); // Read dimension using StdIn
            String name = StdIn.readString(); // Read name using StdIn
            int signature = StdIn.readInt(); // Read signature using StdIn
            // For now, let's just print the information. You can modify this to add people to dimensions.
            System.out.println("Dimension: " + dimension + ", Name: " + name + ", Signature: " + signature);
        }
    }

    
    public void connectClusters() {
        int numClusters = clusters.size();
        Set<Integer> addedDimensions = new HashSet<>(); // Keep track of dimensions already added
        for (int i = 0; i < numClusters; i++) {
            int prev1Index = (i - 1 + numClusters) % numClusters;
            int prev2Index = (i - 2 + numClusters) % numClusters;

            List<Integer> cluster1 = clusters.get(i);
            List<Integer> prev1Cluster = clusters.get(prev1Index);
            List<Integer> prev2Cluster = clusters.get(prev2Index);

            if (!prev1Cluster.isEmpty()) {
                int dimension1 = prev1Cluster.get(0);
                if (!addedDimensions.contains(dimension1)) { // Check if dimension has already been added
                    cluster1.add(dimension1);
                    addedDimensions.add(dimension1); // Mark dimension as added
            }
            }

            if (!prev2Cluster.isEmpty()) {
                int dimension2 = prev2Cluster.get(0);
            if (!addedDimensions.contains(dimension2)) { // Check if dimension has already been added
                cluster1.add(dimension2);
                addedDimensions.add(dimension2); // Mark dimension as added
            }
            }
        }
    }

    public List<List<Integer>> getClusters() {
        return clusters;
    }
}

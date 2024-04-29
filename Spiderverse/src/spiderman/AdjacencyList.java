package spiderman;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyList {

    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int dimension1, int dimension2) {
        adjacencyList.computeIfAbsent(dimension1, k -> new ArrayList<>()).add(dimension2);
        if (dimension1 != dimension2) {
            adjacencyList.computeIfAbsent(dimension2, k -> new ArrayList<>()).add(dimension1);
        }
    }
    

    public void writeToOutputFile(String outputFile) {
        StdOut.setFile(outputFile); // Set output file
    
        List<Integer> alreadyPrinted = new ArrayList<>(); // Keep track of already printed dimensions
for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
    int dimension = entry.getKey();
    if (!alreadyPrinted.contains(dimension)) { // Check if the dimension has already been printed
        List<Integer> connectedDimensions = entry.getValue();
      StdOut.print(dimension); // PRINTS STARTING DIMENSION FOR EACH LINE
      
        for (int connectedDimension : connectedDimensions ) {
            
            StdOut.print(" ");
            StdOut.print(connectedDimension);
        }
        StdOut.println();
        alreadyPrinted.add(dimension); // Add dimension to already printed list
    }
}

}

//WORKDS ABOVE THIS
public List<Integer> getNeighbors(int dimension) {
    return adjacencyList.getOrDefault(dimension, new ArrayList<>());
}
}


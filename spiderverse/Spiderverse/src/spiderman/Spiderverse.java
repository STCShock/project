package spiderman;


import java.util.HashMap;
import java.util.Map;


/**
 * Represents the Spiderverse, which maps dimensions to people.
 * 
 * @author [Author Name]
 */
public class Spiderverse {

    private Map<Integer, String> dimensionToPerson;

    /**
     * Constructs an empty Spiderverse.
     */
    public Spiderverse() {
        dimensionToPerson = new HashMap<>();
    }

    /**
     * Reads the Spiderverse data from a file.
     * 
     * @param fileName the name of the file containing Spiderverse data
     */
    public void readSpiderverseFile(String fileName) {
        StdIn.setFile(fileName); // Set input file
    
        int numPeople = StdIn.readInt();
        StdIn.readLine(); // consume newline
    
        for (int i = 0; i < numPeople; i++) {
            int dimension = StdIn.readInt();
            String name = StdIn.readString();
            int signature = StdIn.readInt();
            dimensionToPerson.put(dimension, name);
        }
    }

    /**
     * Gets the mapping of dimensions to people.
     * 
     * @return the dimension-to-person map
     */
    public Map<Integer, String> getDimensionToPerson() {
        return dimensionToPerson;
    }
}

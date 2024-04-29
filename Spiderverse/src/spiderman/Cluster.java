package spiderman;
import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private List<Integer> dimensions;

    public Cluster() {
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(int dimension) {
        dimensions.add(dimension);
    }

    public List<Integer> getDimensions() {
        return dimensions;
    }

    public int getSize() {
        return dimensions.size();
    }

    // THE CODE ABOVE THIS WORKS DONT TOUCH
}

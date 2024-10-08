package Strategy;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AlgorithmContext<T> {
    private AlgorithmStrategy<T> algorithm;
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.000000"); // 6 decimal places

    public AlgorithmContext(AlgorithmStrategy<T> algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(AlgorithmStrategy<T> algorithm) {
        this.algorithm = algorithm;
    }

    public ArrayList<T> sort(ArrayList<T> array) {
        return algorithm.sort(array);
    }

    public String timeAlgorithm(ArrayList<T> list) {
        long startTime = System.nanoTime();
        algorithm.sort(list);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double elapsedTimeInSeconds = elapsedTime / 1_000_000_000.0;
        
        return decimalFormat.format(elapsedTimeInSeconds); // Return time formatted to 6 decimal places
    }
}

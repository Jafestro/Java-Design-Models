package Strategy;

import java.util.ArrayList;

public class AlgorithmContext<T> {
    @SuppressWarnings("rawtypes")
    private AlgorithmStrategy algorithm;

    public AlgorithmContext(@SuppressWarnings("rawtypes") AlgorithmStrategy algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(@SuppressWarnings("rawtypes") AlgorithmStrategy algorithm) {
        this.algorithm = algorithm;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<T> sort(ArrayList<T> array) {
        return algorithm.sort(array);
    }

    public double timeAlgorithm(ArrayList<T> list) {
        long startTime = System.nanoTime();
        algorithm.sort(list);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        return elapsedTime / 1_000_000_000.0;
    }
}

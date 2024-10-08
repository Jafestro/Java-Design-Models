package Strategy;

import java.util.ArrayList;

public class BubbleSort<T extends Comparable<T>> implements AlgorithmStrategy<T> {
    @Override
    public ArrayList<T> sort(ArrayList<T> array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    // Swap array[j] and array[j+1]
                    T temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
        return array;
    }
}

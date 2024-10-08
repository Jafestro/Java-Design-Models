package Strategy;

import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> implements AlgorithmStrategy<T> {
    @Override
    public ArrayList<T> sort(ArrayList<T> array) {
        quickSort(array, 0, array.size() - 1);
        return array;
    }

    private void quickSort(ArrayList<T> array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(ArrayList<T> array, int low, int high) {
        T pivot = array.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        T temp = array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);
        return i + 1;
    }
}

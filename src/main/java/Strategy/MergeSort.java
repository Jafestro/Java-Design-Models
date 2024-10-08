package Strategy;

import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> implements AlgorithmStrategy<T> {
    @Override
    public ArrayList<T> sort(ArrayList<T> array) {
        if (array.size() > 1) {
            int mid = array.size() / 2;
            ArrayList<T> left = new ArrayList<>(array.subList(0, mid));
            ArrayList<T> right = new ArrayList<>(array.subList(mid, array.size()));

            sort(left);
            sort(right);

            merge(array, left, right);
        }
        return array;
    }

    private void merge(ArrayList<T> array, ArrayList<T> left, ArrayList<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                array.set(k++, left.get(i++));
            } else {
                array.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            array.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            array.set(k++, right.get(j++));
        }
    }
}

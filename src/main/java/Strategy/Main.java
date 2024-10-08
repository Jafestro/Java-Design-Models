package Strategy;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> smallArray = generateRandomArray(30);        // 30 elements
        ArrayList<Integer> largeArray = generateRandomArray(100000);    // 100,000 elements

        AlgorithmContext<Integer> context = new AlgorithmContext<>(new BubbleSort<Integer>());

        // Bubble Sort
        System.out.println("Testing Bubble Sort:");
        System.out.println("Time for small array (30 elements): " + context.timeAlgorithm(new ArrayList<>(smallArray)) + " seconds");
        System.out.println("Time for large array (100,000 elements): " + context.timeAlgorithm(new ArrayList<>(largeArray)) + " seconds");

        // Quick Sort
        System.out.println("\nTesting Quick Sort:");
        context.setAlgorithm(new QuickSort<>());
        System.out.println("Time for small array (30 elements): " + context.timeAlgorithm(new ArrayList<>(smallArray)) + " seconds");
        System.out.println("Time for large array (100,000 elements): " + context.timeAlgorithm(new ArrayList<>(largeArray)) + " seconds");

        // Merge Sort
        System.out.println("\nTesting Merge Sort:");
        context.setAlgorithm(new MergeSort<>());
        System.out.println("Time for small array (30 elements): " + context.timeAlgorithm(new ArrayList<>(smallArray)) + " seconds");
        System.out.println("Time for large array (100,000 elements): " + context.timeAlgorithm(new ArrayList<>(largeArray)) + " seconds");
    }

    // Helper function to generate a random array of integers
    public static ArrayList<Integer> generateRandomArray(int size) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(10000));  // Random numbers between 0 and 9999
        }
        return array;
    }
}

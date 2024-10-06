package Strategy;

import java.util.ArrayList;

public class ClientMain {
    public static void main(String[] args) {
        AlgorithmContext algorithmContext = new AlgorithmContext(new BubbleSort());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        algorithmContext.sort(list);
    }
}

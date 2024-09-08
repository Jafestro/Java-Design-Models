package Observer;

public class ConcreteObserver implements Observer{
    private final String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature, DegreeTypes type) {
        System.out.println(name + " received an update: Current temperature is " + temperature + "°" + type.getSymbol());
    }
}

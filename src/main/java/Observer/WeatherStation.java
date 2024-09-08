package Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread{
    
    private int temperature;
    private DegreeTypes type;
    private List<Observer> observers;
    private final Random random = new Random();
    private volatile boolean running;

    public WeatherStation(DegreeTypes type) {
        this.observers = new ArrayList<>();
        this.temperature = random.nextInt(40);
        this.running = true;
        this.type = type;
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, type);
        }
    }

    private void updateTemperature(){
        int change = random.nextInt(3) - 1;
        temperature = Math.max(-30, Math.min(50, temperature + change)); // Temp range [-30, 50]
        System.out.println("Weather Station: Temperature updated to " + temperature + "°" + type.getSymbol());
        notifyObservers();
    }

    
    @Override
    public void run() {
        while(running) {
            updateTemperature();
            try {
                Thread.sleep((random.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Weather Station interrupted");
            }
        }
    }

    public void stopWeatherStation() {
        running = false;
    }
}

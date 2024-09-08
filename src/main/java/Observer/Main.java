package Observer;

public class Main {
    public static void main(String[] args) {
        // Create weather station
        WeatherStation weatherStation = new WeatherStation(DegreeTypes.CELSIUS);

        // Create observers
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        // Register observers
        weatherStation.subscribe(observer1);
        weatherStation.subscribe(observer2);
        weatherStation.subscribe(observer3);

        // Start weather station thread
        Thread weatherStationThread = new Thread(weatherStation);
        weatherStationThread.start();

        // Let the simulation run for a while
        try {
            Thread.sleep(15000); // Run for 15 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Remove one observer and let the simulation continue
        System.out.println("\nRemoving Observer 2...\n");
        weatherStation.unsubscribe(observer2);

        // Continue the simulation for some more time
        try {
            Thread.sleep(10000); // Run for another 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the weather station
        weatherStation.stopWeatherStation();
        try {
            weatherStationThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Simulation ended.");
    }
}

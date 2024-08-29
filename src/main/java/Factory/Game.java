package Factory;

public class Game {
    public Map createMap(String mapType, int width, int height) {
        switch (mapType.toLowerCase()) {
            case "city" -> {
                return new CityMap(width, height);
            }
            case "wilderness" -> {
                return new WildernessMap(width, height);
            }
            default -> throw new IllegalArgumentException("Unknown map type: " + mapType);
        }
    }

    public void main() {
        // Example usage: create a city map of size 5x5
        String mapType = "wilderness"; // or "wilderness"
        int width = 5;
        int height = 5;
        Map gameMap = createMap(mapType, width, height);
        gameMap.display();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.main();
    }
}
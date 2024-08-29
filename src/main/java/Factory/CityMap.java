package Factory;

import java.util.Random;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        Random rand = new Random();
        int randomTile = rand.nextInt(3);
        return switch (randomTile) {
            case 0 -> new Road();
            case 1 -> new Forest();
            case 2 -> new Building();
            default -> null;
        };
    }
}
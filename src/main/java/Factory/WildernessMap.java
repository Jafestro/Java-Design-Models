package Factory;

import java.util.Random;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        Random rand = new Random();
        int randomTile = rand.nextInt(3);
        return switch (randomTile) {
            case 0 -> new Swamp();
            case 1 -> new Water();
            case 2 -> new Forest();
            default -> null;
        };
    }
}
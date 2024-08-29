package Factory;

public class Road implements Tile {

    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }
    
}

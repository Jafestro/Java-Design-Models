package Factory;

public abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] grid;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Tile[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = createTile();
            }
        }
    }

    protected abstract Tile createTile();

    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
package State;

public enum Threshold {
    NOVICE(0),
    INTERMEDIATE(200),
    EXPERT(1000),
    MASTER(10000);

    private final int exp;

    Threshold(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }
}

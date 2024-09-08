package Observer;

public enum DegreeTypes {
    CELSIUS("C"),
    FAHRENHEIT("F"),
    KELVIN("K");

    private final String symbol;

    DegreeTypes(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
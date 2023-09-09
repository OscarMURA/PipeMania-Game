package model;

public enum TypePipe {
    F("F"),
    D("D"),
    VERTICAL("||"),
    HORIZONTAL("="),
    CIRCULAR("o");

    private final String symbol;

    TypePipe(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
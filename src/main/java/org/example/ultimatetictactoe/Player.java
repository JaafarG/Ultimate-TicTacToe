package org.example.ultimatetictactoe;

public class Player {
    private String name;
    private int score;
    public Symbol symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
}
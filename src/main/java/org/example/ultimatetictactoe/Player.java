package org.example.ultimatetictactoe;

public class Player {
    private String name;
    private int ipAddress;
    private int score;
    public Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public void chooseMove() {

    }

    public void quit() {
    }
}
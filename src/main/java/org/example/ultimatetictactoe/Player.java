package org.example.ultimatetictactoe;

public class Player {
    private String name;
    private boolean winner;
    private boolean starter;
    private boolean me;
    public Symbol symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isStarter() {
        return starter;
    }

    public void setStarter(boolean starter) {
        this.starter = starter;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Player(String name, boolean me) {
        this.name = name;
        this.winner = false;
        this.starter = false;
        this.me = me;
        this.symbol = null;
    }

    public Player(String name) {
        new Player(name, true);
    }
}
package org.example.ultimatetictactoe;

public class Player {
    private String name;
    private boolean winner;
    private boolean starter;
    private boolean serverPlayer;
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

    public boolean isServerPlayer() {
        return serverPlayer;
    }

    public void setServerPlayer(boolean serverPlayer) {
        this.serverPlayer = serverPlayer;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Player(String name, boolean serverPlayer) {
        this.name = name;
        this.winner = false;
        this.serverPlayer = serverPlayer;
        this.starter = true;
        this.symbol = (serverPlayer) ? Symbol.X : Symbol.O;
    }

    public Player(String name) {
        new Player(name, true);
    }
}
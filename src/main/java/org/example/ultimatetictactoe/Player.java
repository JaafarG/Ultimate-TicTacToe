package org.example.ultimatetictactoe;

import java.sql.Date;

public class Player {
    private String name;
    private int IDPlayer;
    private String passwordHash;
    private java.sql.Date profileCreationDate;
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

    public int getIDPlayer() {
        return IDPlayer;
    }

    public void setIDPlayer(int IDPlayer) {
        this.IDPlayer = IDPlayer;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public java.sql.Date getProfileCreationDate() {
        return profileCreationDate;
    }

    public void setProfileCreationDate(java.sql.Date profileCreationDate) {
        this.profileCreationDate = profileCreationDate;
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

    public Player(int idPlayer, String name, String passwordHash, Date profileCreationDate) {
        this.IDPlayer = idPlayer;
        this.name = name;
        this.passwordHash = passwordHash;
        this.profileCreationDate = profileCreationDate;
    }

    public Player(String name) {
        new Player(name, true);
    }
}
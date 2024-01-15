package org.example.ultimatetictactoe;

import java.sql.Date;

/**
 * Represents a player in the Ultimate Tic Tac Toe game.
 */
public class Player {
    private String username; // The player's name
    private int IDPlayer; // The player's ID
    private String passwordHash; // The hashed password for the player (for authentication)
    private java.sql.Date profileCreationDate; // The date when the player's profile was created
    private boolean winner; // Indicates if the player is a winner
    private boolean starter; // Indicates if the player is a game starter
    private boolean me; // Indicates if the player represents the local player
    public Symbol symbol; // The player's symbol (X or O)

    /**
     * Gets the player's name.
     *
     * @return The player's name.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the player's name.
     *
     * @param username The player's name to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the player's ID.
     *
     * @return The player's ID.
     */
    public int getIDPlayer() {
        return IDPlayer;
    }

    /**
     * Sets the player's ID.
     *
     * @param IDPlayer The player's ID to set.
     */
    public void setIDPlayer(int IDPlayer) {
        this.IDPlayer = IDPlayer;
    }

    /**
     * Gets the hashed password for the player.
     *
     * @return The hashed password for the player.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets the hashed password for the player.
     *
     * @param passwordHash The hashed password to set.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Gets the date when the player's profile was created.
     *
     * @return The profile creation date.
     */
    public java.sql.Date getProfileCreationDate() {
        return profileCreationDate;
    }

    /**
     * Sets the date when the player's profile was created.
     *
     * @param profileCreationDate The profile creation date to set.
     */
    public void setProfileCreationDate(java.sql.Date profileCreationDate) {
        this.profileCreationDate = profileCreationDate;
    }

    /**
     * Checks if the player is a winner.
     *
     * @return true if the player is a winner, false otherwise.
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * Sets the winner status of the player.
     *
     * @param winner true if the player is a winner, false otherwise.
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    /**
     * Checks if the player is a game starter.
     *
     * @return true if the player is a game starter, false otherwise.
     */
    public boolean isStarter() {
        return starter;
    }

    /**
     * Sets the game starter status of the player.
     *
     * @param starter true if the player is a game starter, false otherwise.
     */
    public void setStarter(boolean starter) {
        this.starter = starter;
    }

    /**
     * Checks if the player represents the local player.
     *
     * @return true if the player represents the local player, false otherwise.
     */
    public boolean isMe() {
        return me;
    }

    /**
     * Sets whether the player represents the local player.
     *
     * @param me true if the player represents the local player, false otherwise.
     */
    public void setMe(boolean me) {
        this.me = me;
    }

    /**
     * Gets the player's symbol (X or O).
     *
     * @return The player's symbol.
     */
    public Symbol getSymbol() {
        return symbol;
    }

    /**
     * Sets the player's symbol (X or O).
     *
     * @param symbol The player's symbol to set.
     */
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    /**
     * Constructs a new Player object with a name and whether it represents the local player.
     *
     * @param username The player's name.
     * @param me   true if the player represents the local player, false otherwise.
     */
    public Player(String username, boolean me) {
        this.username = username;
        this.winner = false;
        this.starter = false;
        this.me = me;
        this.symbol = null;
    }

    /**
     * Constructs a Player object with an ID, name, password hash, and profile creation date.
     *
     * @param idPlayer           The player's ID.
     * @param username               The player's name.
     * @param passwordHash       The hashed password for the player.
     * @param profileCreationDate The date when the player's profile was created.
     */
    public Player(int idPlayer, String username, String passwordHash, Date profileCreationDate) {
        this.IDPlayer = idPlayer;
        this.username = username;
        this.passwordHash = passwordHash;
        this.profileCreationDate = profileCreationDate;
    }

    /**
     * Constructs a Player object with a name.
     *
     * @param username The player's name.
     */
    public Player(String username) {
        new Player(username, true);
    }
}

package org.example.ultimatetictactoe;

public class Game {
    private Board board;
    private Player[] players = new Player[2];

    public Game(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
    }

    public void chooseFirstPlayer() {
        // Randomly choose the first player
    }


    public void checkGameEnd() {
        // Implement game end check
    }

    public void init(Player p1, Player p2) {
        // Game initialization logic
    }
}

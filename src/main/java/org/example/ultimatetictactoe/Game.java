package org.example.ultimatetictactoe;

public class Game {
    private Board board;
    private Player[] players = new Player[2];

    public Game(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
    }

    public Player chooseFirstPlayer(Player[] players) {
        if (Math.random() < 0.5){
            return players[0];
        }
        return players[1];
    }


    public void checkGameEnd() {
    }

    public void init(Player p1, Player p2) {
        // Game initialization logic
    }
}

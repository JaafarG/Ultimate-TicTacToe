package org.example.ultimatetictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game {
    static Board board;
    public static Player[] players = new Player[2];

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


    public boolean checkGameWin(Player p1) {
        // Check all rows
        for (int i = 0; i < 3; i++) {
            if ((board.BigGrid.cells[i][0] != p1.symbol) && (board.BigGrid.cells[i][0] == board.BigGrid.cells[i][1]) && (board.BigGrid.cells[i][0] == board.BigGrid.cells[i][2])) {
                return true;

            }
        }

        // Check all columns
        for (int j = 0; j < 3; j++) {
            if (board.BigGrid.cells[0][j] != p1.symbol && board.BigGrid.cells[0][j] == board.BigGrid.cells[1][j] && board.BigGrid.cells[0][j] == board.BigGrid.cells[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board.BigGrid.cells[0][0] != p1.symbol && board.BigGrid.cells[0][0] == board.BigGrid.cells[1][1] && board.BigGrid.cells[0][0] == board.BigGrid.cells[2][2]) {
            return true;
        }
        if (board.BigGrid.cells[0][2] != p1.symbol && board.BigGrid.cells[0][2] == board.BigGrid.cells[1][1] && board.BigGrid.cells[0][2] == board.BigGrid.cells[2][0]) {
            return true;
        }

        // If no win condition met, return false
        return false;
    }

    public static void playMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {

        if (board.validateMove(BigGrid1, BigGrid2, SmallGrid1, SmallGrid2)){

            board.grid[BigGrid1][BigGrid2].updateCell(SmallGrid1, SmallGrid2, board.currentPlayer.symbol);

            board.CurrentGrid[SmallGrid1][SmallGrid2] = true;

            for (int i = 0; i < board.grid.length; i++) {

                for (int j = 0; j < board.grid[i].length; j++) {

                    if (SmallGrid1 != i && SmallGrid2 != j ){

                        board.CurrentGrid[i][j] = false;
                    }

                }
            }
            if (board.currentPlayer == players[1]){
                board.currentPlayer = players[0];
            }
            if (board.currentPlayer == players[0]){
                board.currentPlayer = players[1];
            }
        }

    }



}

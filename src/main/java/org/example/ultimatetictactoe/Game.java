package org.example.ultimatetictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Game {
    public Board board;
    public  Player[] players = new Player[2];

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Game(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
    }

    public void chooseFirstPlayer() {
        if (Math.random() < 0.5){
            board.setCurrentPlayer(players[0]);
        } else {
            board.setCurrentPlayer(players[1]);
        }
    }

    public boolean checkGameWin(Player p1) {
        // Check all rows
        for (int i = 0; i < 3; i++) {
            if ((board.getBigGrid().cells[i][0] != p1.symbol) && (board.getBigGrid().cells[i][0] == board.getBigGrid().cells[i][1]) && (board.getBigGrid().cells[i][0] == board.getBigGrid().cells[i][2])) {
                return true;
            }
        }

        // Check all columns
        for (int j = 0; j < 3; j++) {
            if (board.getBigGrid().cells[0][j] != p1.symbol && board.getBigGrid().cells[0][j] == board.getBigGrid().cells[1][j] && board.getBigGrid().cells[0][j] == board.getBigGrid().cells[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board.getBigGrid().cells[0][0] != p1.symbol && board.getBigGrid().cells[0][0] == board.getBigGrid().cells[1][1] && board.getBigGrid().cells[0][0] == board.getBigGrid().cells[2][2]) {
            return true;
        }
        if (board.getBigGrid().cells[0][2] != p1.symbol && board.getBigGrid().cells[0][2] == board.getBigGrid().cells[1][1] && board.getBigGrid().cells[0][2] == board.getBigGrid().cells[2][0]) {
            return true;
        }

        // If no win condition met, return false
        return false;
    }

    public void playMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {
        board.getGrid()[BigGrid1][BigGrid2].updateCell(SmallGrid1, SmallGrid2, board.getCurrentPlayer().symbol);

        if (!board.getGrid()[SmallGrid1][SmallGrid2].win && !board.getGrid()[SmallGrid1][SmallGrid2].full ) {
            for (int i = 0; i < board.getGrid().length; i++) {
                for (int j = 0; j < board.getGrid()[i].length; j++) {
                    board.getCurrentGrid()[i][j] = false;
                }
            }
            board.getCurrentGrid()[SmallGrid1][SmallGrid2] = true;
        }else{
            for (int i = 0; i < board.getGrid().length; i++) {

                for (int j = 0; j < board.getGrid()[i].length; j++) {

                    if(!board.getGrid()[SmallGrid1][SmallGrid2].win){

                        board.getCurrentGrid()[i][j] = true;
                    }
                }
            }

        }
        board.getGrid()[BigGrid1][BigGrid2].win = board.getGrid()[BigGrid1][BigGrid2].checkSmallGridWin();

        if (board.getCurrentPlayer() == players[1]){
            board.setCurrentPlayer(players[0]);
        }else{
            board.setCurrentPlayer(players[1]);
        }
    }
}

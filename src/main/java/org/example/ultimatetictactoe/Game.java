package org.example.ultimatetictactoe;


public class Game {
    private Board board;
    private Player[] players = new Player[2];
    private Player currentPlayer;
    private boolean gameOver;

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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameState(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Game(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
        gameOver = false;
    }

    public void chooseFirstPlayer() {
        if (Math.random() < 0.5){
            currentPlayer = players[0];
            players[0].setStarter(true);
        } else {
            currentPlayer = players[1];
            players[1].setStarter(true);
        }
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == players[1]){
            currentPlayer = players[0];
        }else{
            currentPlayer = players[1];
        }
    }

    public boolean checkGameWin(Player p1) {
        // Check all rows
        for (int i = 0; i < 3; i++) {
            if ((board.getGridView().getCells()[i][0] != p1.symbol) && (board.getGridView().getCells()[i][0] == board.getGridView().getCells()[i][1]) && (board.getGridView().getCells()[i][0] == board.getGridView().getCells()[i][2])) {
                return true;
            }
        }

        // Check all columns
        for (int j = 0; j < 3; j++) {
            if (board.getGridView().getCells()[0][j] != p1.symbol && board.getGridView().getCells()[0][j] == board.getGridView().getCells()[1][j] && board.getGridView().getCells()[0][j] == board.getGridView().getCells()[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board.getGridView().getCells()[0][0] != p1.symbol && board.getGridView().getCells()[0][0] == board.getGridView().getCells()[1][1] && board.getGridView().getCells()[0][0] == board.getGridView().getCells()[2][2]) {
            return true;
        }
        if (board.getGridView().getCells()[0][2] != p1.symbol && board.getGridView().getCells()[0][2] == board.getGridView().getCells()[1][1] && board.getGridView().getCells()[0][2] == board.getGridView().getCells()[2][0]) {
            return true;
        }

        // If no win condition met, return false
        return false;
    }

    public void playMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {
        board.getGrid()[BigGrid1][BigGrid2].updateCell(SmallGrid1, SmallGrid2, currentPlayer.symbol);
        // If it's a winning move update gridview
        if (board.getGrid()[BigGrid1][BigGrid2].checkSmallGridWin()){
            board.getGridView().updateCell(BigGrid1, BigGrid2, currentPlayer.getSymbol());
        }
        // If the current big grid is not full or won by a player
        if (board.getGrid()[SmallGrid1][SmallGrid2].isWin() || board.getGrid()[SmallGrid1][SmallGrid2].isFull() ) {

            for (int i = 0; i < board.getGrid().length; i++) {

                for (int j = 0; j < board.getGrid()[i].length; j++) {
                    System.out.println("Current grids will be : " + SmallGrid1 + SmallGrid2);
                    if (!board.getGrid()[i][j].isWin() && !board.getGrid()[i][j].isFull() ) {
                        board.getCurrentGrid()[i][j] = true;
                        System.out.println("Current grids will be : " + i + j);
                    }
                }
            }
        }else{
            for (int i = 0; i < board.getGrid().length; i++) {

                for (int j = 0; j < board.getGrid()[i].length; j++) {

                    board.getCurrentGrid()[i][j] = false;
                }
            }
            board.getCurrentGrid()[SmallGrid1][SmallGrid2] = true;
            System.out.println("Current grids will be : " + SmallGrid1 + SmallGrid2);

        }
        board.getGrid()[BigGrid1][BigGrid2].setWin(board.getGrid()[BigGrid1][BigGrid2].checkSmallGridWin());

        // Switch the current player
        if (currentPlayer == players[1]){
            currentPlayer = players[0];
        }else{
            currentPlayer = players[1];
        }
    }
}

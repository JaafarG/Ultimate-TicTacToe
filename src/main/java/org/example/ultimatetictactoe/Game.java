package org.example.ultimatetictactoe;


import java.sql.Date;
import java.sql.Timestamp;


/**
 * Represents a game of Ultimate Tic Tac Toe.
 */
public class Game {
    private int IDGame; //Game ID

    private java.sql.Timestamp gameDate; //Date of the game

    private Board board; //Game board
    private Player[] players = new Player[2]; //The game's players
    private Player currentPlayer;  //The current player
    private boolean gameOver; //A boolean that displays the game's end
    private Smallgrid gridView = new Smallgrid(); //A Smallgrid object that is used to display the Main grid's state
    private int SymbolSkin; //An integer that displays which skin has been chosen

    /**
     * Gets the unique identifier for this game.
     *
     * @return The game's ID.
     */
    public int getIDGame() {
        return IDGame;
    }

    /**
     * Sets the unique identifier for this game.
     *
     * @param IDGame The game's ID to set.
     */
    public void setIDGame(int IDGame) {
        this.IDGame = IDGame;
    }

    /**
     * Gets the date and time when the game was played.
     *
     * @return The game's date and time.
     */
    public java.sql.Timestamp getGameDate() {
        return gameDate;
    }

    /**
     * Sets the date and time when the game was played.
     *
     * @param gameDate The game's date and time to set.
     */
    public void setGameDate(java.sql.Timestamp gameDate) {
        this.gameDate = gameDate;
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Sets whether the game is over.
     *
     * @param gameOver true if the game is over, false otherwise.
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Gets the game's playing board.
     *
     * @return The game's board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets the game's playing board.
     *
     * @param board The board to set.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Gets the array of players in the game.
     *
     * @return An array of Player objects.
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Sets the array of players in the game.
     *
     * @param players An array of Player objects to set.
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Gets the current player whose turn it is.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets the current player whose turn it is.
     *
     * @param currentPlayer The current player to set.
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Sets the game's state to either over or not over.
     *
     * @param gameOver true if the game is over, false otherwise.
     */
    public void setGameState(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Gets the grid representing the small grids in the game.
     *
     * @return The game's Smallgrid.
     */
    public Smallgrid getGridView() {
        return gridView;
    }

    /**
     * Sets the grid representing the small grids in the game.
     *
     * @param gridView The Smallgrid to set.
     */
    public void setGridView(Smallgrid gridView) {
        this.gridView = gridView;
    }

    /**
     * Gets the skin or theme of the game symbols.
     *
     * @return The symbol skin.
     */
    public int getSymbolSkin() {
        return SymbolSkin;
    }

    /**
     * Sets the skin or theme of the game symbols.
     *
     * @param symbolSkin The symbol skin to set.
     */
    public void setSymbolSkin(int symbolSkin) {
        this.SymbolSkin = symbolSkin;
    }

    /**
     * Constructs a new game with two players and a symbol skin.
     *
     * @param p1          The first player.
     * @param p2          The second player.
     * @param symbolSkin  The symbol skin/theme to use in the game.
     */
    public Game(Player p1, Player p2, int symbolSkin) {
        players[0] = p1;
        players[1] = p2;
        board = new Board();
        gameOver = false;
        SymbolSkin = symbolSkin;
    }

    /**
     * Constructs a game with specific parameters.
     *
     * @param idGame      The game's ID.
     * @param gameDate    The date and time when the game was played.
     * @param finished    true if the game is finished, false otherwise.
     * @param idWinner    The ID of the winning player.
     * @param idPlayerX   The ID of player X.
     * @param idPlayerO   The ID of player O.
     */
    public Game(int idGame, Timestamp gameDate, boolean finished, int idWinner, int idPlayerX, int idPlayerO) {
        this.IDGame = idGame;
        this.gameDate = gameDate;
        this.gameOver = finished;
    }
    /**
     * Randomly chooses the first player to start the game.
     */
    public void chooseFirstPlayer() {
        if (Math.random() < 0.5){
            currentPlayer = players[0];
            players[0].setStarter(true);
        } else {
            currentPlayer = players[1];
            players[1].setStarter(true);
        }
    }
    /**
     * Switches the current player after a move.
     */
    public void switchCurrentPlayer() {
        if (currentPlayer == players[1]){
            currentPlayer = players[0];
        }else{
            currentPlayer = players[1];
        }
    }
    /**
     * Checks if the game is won by a player.
     *
     * @param p1 The player to check for a win.
     * @return true if the game is won by the player, false otherwise.
     */
    public boolean checkGameWin(Player p1) {
        return gridView.checkSmallGridWin();
    }

    /**
     * Plays a move in the game.
     *
     * @param BigGrid1   The row index of the big grid.
     * @param BigGrid2   The column index of the big grid.
     * @param SmallGrid1 The row index of the small grid.
     * @param SmallGrid2 The column index of the small grid.
     */
    public void playMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {
        // Update the cell in the big grid with the current player's symbol
        board.getGrid()[BigGrid1][BigGrid2].updateCell(SmallGrid1, SmallGrid2, currentPlayer.symbol);

        // Check if the move results in a win in the small grid, and update the gridview if needed
        if (board.getGrid()[BigGrid1][BigGrid2].checkSmallGridWin()) {
            gridView.updateCell(BigGrid1, BigGrid2, currentPlayer.getSymbol());
        }
        // Check if the move results in a full small grid, and update the board if needed
        board.getGrid()[BigGrid1][BigGrid2].setFull(board.getGrid()[BigGrid1][BigGrid2].checkSmallGridFull());



        // Check if the current big grid is full or won by a player
        if (board.getGrid()[SmallGrid1][SmallGrid2].isWin() || board.getGrid()[SmallGrid1][SmallGrid2].isFull()) {
            // Iterate through all small grids and mark them as playable if not won or full
            for (int i = 0; i < board.getGrid().length; i++) {
                for (int j = 0; j < board.getGrid()[i].length; j++) {
                    System.out.println("Current grids will be : " + SmallGrid1 + SmallGrid2);
                    if (!board.getGrid()[i][j].isWin() && !board.getGrid()[i][j].isFull()) {
                        board.getCurrentGrid()[i][j] = true;
                        System.out.println("Current grids will be : " + i + j);
                    }
                }
            }
        } else {
            // Mark all small grids as unplayable, except for the current one
            for (int i = 0; i < board.getGrid().length; i++) {
                for (int j = 0; j < board.getGrid()[i].length; j++) {
                    board.getCurrentGrid()[i][j] = false;
                }
            }
            board.getCurrentGrid()[SmallGrid1][SmallGrid2] = true;
            System.out.println("Current grids will be : " + SmallGrid1 + SmallGrid2);
        }

        // Check if the current small grid is won by the current player and not full
        if ((SmallGrid2 == BigGrid2 && SmallGrid1 == BigGrid1) && (board.getGrid()[BigGrid1][BigGrid2].checkSmallGridWin() || board.getGrid()[BigGrid1][BigGrid2].checkSmallGridFull()))
        {
            // Iterate through all small grids and mark them as playable if not won or full
            for (int i = 0; i < board.getGrid().length; i++) {
                for (int j = 0; j < board.getGrid()[i].length; j++) {
                    System.out.println("Current grids will be : " + SmallGrid1 + SmallGrid2);
                    if (!board.getGrid()[i][j].isWin() && !board.getGrid()[i][j].isFull()) {
                        board.getCurrentGrid()[i][j] = true;
                        System.out.println("Current grids will be : " + i + j);
                    }
                }
            }
            board.getCurrentGrid()[SmallGrid1][SmallGrid2] = false;
        }

        // Set the win status of the big grid based on the small grid's win status
        board.getGrid()[BigGrid1][BigGrid2].setWin(board.getGrid()[BigGrid1][BigGrid2].checkSmallGridWin());

        // Switch the current player for the next turn
        switchCurrentPlayer();
    }
}

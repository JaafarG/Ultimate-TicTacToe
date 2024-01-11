package org.example.ultimatetictactoe;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Board {
    private  Smallgrid[][] grid = new Smallgrid[3][3];
    private boolean[][] CurrentGrid = new boolean[3][3];
    private Smallgrid BigGrid = new Smallgrid();
    private Player currentPlayer;

    public Smallgrid[][] getGrid() {
        return grid;
    }

    public void setGrid(Smallgrid[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getCurrentGrid() {
        return CurrentGrid;
    }

    public void setCurrentGrid(boolean[][] currentGrid) {
        CurrentGrid = currentGrid;
    }

    public Smallgrid getBigGrid() {
        return BigGrid;
    }

    public void setBigGrid(Smallgrid bigGrid) {
        BigGrid = bigGrid;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Board() {
        // Initialize the board with empty Smallgrid objects
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Smallgrid();
                CurrentGrid[i][j] = true;
            }
        }
        System.out.println("Board was initialized");
    }

    boolean validateMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {
        return (CurrentGrid[BigGrid1][BigGrid2] && grid[BigGrid1][BigGrid2].validateMove(SmallGrid1,SmallGrid2));
    }
}
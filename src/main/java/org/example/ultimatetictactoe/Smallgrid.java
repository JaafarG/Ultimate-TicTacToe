package org.example.ultimatetictactoe;

/**
 * Represents a small grid within the Ultimate Tic Tac Toe board.
 */
public class Smallgrid {
    private Symbol[][] cells = new Symbol[3][3]; // The 3x3 grid of Symbol objects
    private boolean win; // Indicates if this small grid has been won
    private boolean full; // Indicates if this small grid is full

    /**
     * Gets the grid of Symbol objects representing the cells.
     *
     * @return The 3x3 grid of Symbol objects.
     */
    public Symbol[][] getCells() {
        return cells;
    }

    /**
     * Sets the grid of Symbol objects representing the cells.
     *
     * @param cells The 3x3 grid of Symbol objects to set.
     */
    public void setCells(Symbol[][] cells) {
        this.cells = cells;
    }

    /**
     * Checks if this small grid has been won.
     *
     * @return true if the small grid is won, false otherwise.
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Sets the win status of this small grid.
     *
     * @param win true if the small grid is won, false otherwise.
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    /**
     * Checks if this small grid is full (no empty cells).
     *
     * @return true if the small grid is full, false otherwise.
     */
    public boolean isFull() {
        return full;
    }

    /**
     * Sets the full status of this small grid.
     *
     * @param full true if the small grid is full, false otherwise.
     */
    public void setFull(boolean full) {
        this.full = full;
    }

    /**
     * Constructs a new Smallgrid and initializes it with empty cells.
     * Also initializes the win and full status to false.
     */
    public Smallgrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = null; // Initialize cells with null (empty)
            }
        }
        win = false;
        full = false;
    }

    /**
     * Checks if this small grid is full.
     *
     * @return true if the small grid is full, false otherwise.
     */
    public boolean checkSmallGridFull() {
        int full = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] != null) {
                    full++;
                }
            }
        }
        return (full == 9);

    }

    /**
     * Checks if this small grid is won by a player.
     *
     * @return true if the small grid is won, false otherwise.
     */
    public boolean checkSmallGridWin() {
        // Check all rows
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != null && cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2]) {
                return true;
            }
        }

        // Check all columns
        for (int j = 0; j < 3; j++) {
            if (cells[0][j] != null && cells[0][j] == cells[1][j] && cells[0][j] == cells[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (cells[0][0] != null && cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2]) {
            return true;
        }
        if (cells[0][2] != null && cells[0][2] == cells[1][1] && cells[0][2] == cells[2][0]) {
            return true;
        }

        // If no win condition is met, return false
        return false;
    }

    /**
     * Validates if a move is allowed in this small grid.
     *
     * @param SmallGrid1 The row index of the small grid.
     * @param SmallGrid2 The column index of the small grid.
     * @return true if the move is valid (cell is empty), false otherwise.
     */
    public boolean validateMove(int SmallGrid1, int SmallGrid2) {
        return (cells[SmallGrid1][SmallGrid2] == null); // Check if the cell is empty
    }

    /**
     * Updates a cell in this small grid with a player's symbol.
     *
     * @param SmallGrid1 The row index of the cell.
     * @param SmallGrid2 The column index of the cell.
     * @param symbol     The player's symbol to set in the cell.
     */
    public void updateCell(int SmallGrid1, int SmallGrid2, Symbol symbol) {
        cells[SmallGrid1][SmallGrid2] = symbol;
    }
}

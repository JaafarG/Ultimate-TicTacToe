package org.example.ultimatetictactoe;

/**
 * Represents the game board, consisting of a grid of Smallgrid objects.
 */
public class Board {
    private Smallgrid[][] grid = new Smallgrid[3][3]; // The 3x3 grid of Smallgrid objects
    private boolean[][] currentGrid = new boolean[3][3]; // A boolean grid to track the current playable grids

    /**
     * Gets the grid of Smallgrid objects.
     *
     * @return The 3x3 grid of Smallgrid objects.
     */
    public Smallgrid[][] getGrid() {
        return grid;
    }

    /**
     * Sets the grid of Smallgrid objects.
     *
     * @param grid The 3x3 grid of Smallgrid objects to set.
     */
    public void setGrid(Smallgrid[][] grid) {
        this.grid = grid;
    }

    /**
     * Gets the current playable grid status.
     *
     * @return A boolean grid indicating the current playable grids.
     */
    public boolean[][] getCurrentGrid() {
        return currentGrid;
    }

    /**
     * Sets the current playable grid status.
     *
     * @param currentGrid A boolean grid indicating the current playable grids to set.
     */
    public void setCurrentGrid(boolean[][] currentGrid) {
        this.currentGrid = currentGrid;
    }

    /**
     * Constructs a new game board and initializes it with empty Smallgrid objects.
     * Also initializes the currentGrid to allow all grids to be initially playable.
     */
    public Board() {
        // Initialize the board with empty Smallgrid objects
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Smallgrid();
                currentGrid[i][j] = true;
            }
        }
        System.out.println("Board was initialized");
    }

    /**
     * Validates a move on the board, checking if it's a valid move within the current grid.
     *
     * @param BigGrid1   The row index of the big grid.
     * @param BigGrid2   The column index of the big grid.
     * @param SmallGrid1 The row index of the small grid.
     * @param SmallGrid2 The column index of the small grid.
     * @return true if the move is valid, false otherwise.
     */
    public boolean validateMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {
        // Check if the specified small grid is playable within the current big grid
        return (currentGrid[BigGrid1][BigGrid2] && grid[BigGrid1][BigGrid2].validateMove(SmallGrid1, SmallGrid2));
    }
}

package org.example.ultimatetictactoe;

public class Board {
    private  Smallgrid[][] grid = new Smallgrid[3][3];
    private boolean[][] currentGrid = new boolean[3][3];


    public Smallgrid[][] getGrid() {
        return grid;
    }

    public void setGrid(Smallgrid[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getCurrentGrid() {
        return currentGrid;
    }

    public void setCurrentGrid(boolean[][] currentGrid) {
        this.currentGrid = currentGrid;
    }

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

    public boolean validateMove(int BigGrid1, int BigGrid2, int SmallGrid1, int SmallGrid2) {
        return (currentGrid[BigGrid1][BigGrid2] && grid[BigGrid1][BigGrid2].validateMove(SmallGrid1,SmallGrid2));
    }
}
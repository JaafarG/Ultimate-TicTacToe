package org.example.ultimatetictactoe;

public class Board {
    private Smallgrid[][] grid = new Smallgrid[3][3];
    private boolean[][] CurrentGrid = new boolean[3][3];
    private Smallgrid BigGrid = new Smallgrid();
    private Player currentPlayer;

    public Board() {
        // Initialize the board with empty Smallgrid objects
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Smallgrid();
                CurrentGrid[i][j] = true;
            }
        }
    }

   /* public void displayBoard() {
        // Implement display logic
    }*/

    public void boardInitialisation() {
        // Implement board initialization logic
    }

    public void playMove(int BigGrid1,int BigGrid2, int SmallGrid1,int SmallGrid2) {
        if (validateMove(BigGrid1, BigGrid2, SmallGrid1, SmallGrid2)){
            grid[BigGrid1][BigGrid2].updateCell(SmallGrid1, SmallGrid2, currentPlayer.symbol);
        }

    }

    private boolean validateMove(int BigGrid1,int BigGrid2, int SmallGrid1,int SmallGrid2) {

        return (CurrentGrid[BigGrid1][BigGrid2] && grid[BigGrid1][BigGrid2].validateMove(SmallGrid1,SmallGrid2));
    }
}
package org.example.ultimatetictactoe;

public class Board {
    private Smallgrid[][] grid = new Smallgrid[3][3];
    private Player currentPlayer;

    public Board() {
        // Initialize the board with empty Smallgrid objects
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Smallgrid();
            }
        }
    }

    public void displayBoard() {
        // Implement display logic
    }

    public void boardInitialisation() {
        // Implement board initialization logic
    }

    public void playMove(int[] coord) {
        // Implement move playing logic
    }

    private boolean validateMove(int[] coord) {
        // Implement move validation logic
        return true;
    }
}
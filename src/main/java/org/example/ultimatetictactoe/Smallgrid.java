package org.example.ultimatetictactoe;

public class Smallgrid {
    private Symbol[][] cells = new Symbol[3][3];

    public Smallgrid() {
        // Initialize the cells with empty symbols
    }

    public boolean checkSmallGridWin(Symbol[][] cells) {
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

        // If no win condition met, return false
        return false;
    }
    public boolean validateMove(int[] coord) {
        // Validate the move within the small grid
        return true;
    }
}
package org.example.ultimatetictactoe;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Board {
    public  Smallgrid[][] grid = new Smallgrid[3][3];
    boolean[][] CurrentGrid = new boolean[3][3];
    public Smallgrid BigGrid = new Smallgrid();
    public Player currentPlayer;

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
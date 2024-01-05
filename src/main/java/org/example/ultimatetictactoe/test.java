package org.example.ultimatetictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class test {

   /*     @FXML
    public void onButton2020clicked() {
        if (board != null && board.validateMove(2,0,2,0)) {
            currentGame.playMove(2,0,2,0);
            button0202.setOpacity(1.0);
            changeText();
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }

    }



    public void onButton2222clicked() {
        if (board != null && board.validateMove(2,2,2,2)) {
            currentGame.playMove(2,2,2,2);
            changeText();
            ChangeImage(button2222);
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }
    }


    @FXML
    public void onButton2000clicked() {
        if (board != null && board.validateMove(2,0,0,0)) {
            currentGame.playMove(2,0,0,0);
            changeText();
            ChangeImage(button2000);
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }
    }
    @FXML
    public void onButton0000clicked() {

       if (board != null && board.validateMove(0,0,0,0)) {
           changeText();
           imageViewX.setOpacity(1.0);
           currentGame.playMove(0,0,0,0);
           System.out.println("Board isn't  null");
           NotAllowedText.setOpacity(0.0);
       }else{
           NotAllowedText.setOpacity(1.0);
       }
       if (board == null) {
            System.out.println("Board is  null");
       }


    }

    @FXML
    public void onButton0010clicked() {

        if (board != null && board.validateMove(0,0,1,0)) {
            changeText();
            imageViewX2.setOpacity(1.0);
            currentGame.playMove(0,0,1,0);
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }


    }
*/

    /*@FXML
    public void onButton0000clicked() { Game.playMove(0,0,0,0); }
    @FXML
    public void onButton0001clicked() { Game.playMove(0,0,0,1); }
    @FXML
    public void onButton0002clicked() { Game.playMove(0,0,0,2); }
    @FXML
    public void onButton0010clicked() { Game.playMove(0,0,1,0); }
    @FXML
    public void onButton0011clicked() { Game.playMove(0,0,1,1); }
    @FXML
    public void onButton0012clicked() { Game.playMove(0,0,1,2); }
    @FXML
    public void onButton0020clicked() { Game.playMove(0,0,2,0); }
    @FXML
    public void onButton0021clicked() { Game.playMove(0,0,2,1); }
    @FXML
    public void onButton0022clicked() { Game.playMove(0,0,2,2); }
    @FXML
    public void onButton0100clicked() { Game.playMove(0,1,0,0); }
    @FXML
    public void onButton0101clicked() { Game.playMove(0,1,0,1); }
    @FXML
    public void onButton0102clicked() { Game.playMove(0,1,0,2); }
    @FXML
    public void onButton0110clicked() { Game.playMove(0,1,1,0); }
    @FXML
    public void onButton0111clicked() { Game.playMove(0,1,1,1); }
    @FXML
    public void onButton0112clicked() { Game.playMove(0,1,1,2); }
    @FXML
    public void onButton0120clicked() { Game.playMove(0,1,2,0); }
    @FXML
    public void onButton0121clicked() { Game.playMove(0,1,2,1); }
    @FXML
    public void onButton0122clicked() { Game.playMove(0,1,2,2); }
    @FXML
    public void onButton0200clicked() { Game.playMove(0,2,0,0); }
    @FXML
    public void onButton0201clicked() { Game.playMove(0,2,0,1); }
    @FXML
    public void onButton0202clicked() { Game.playMove(0,2,0,2); }
    @FXML
    public void onButton0210clicked() { Game.playMove(0,2,1,0); }
    @FXML
    public void onButton0211clicked() { Game.playMove(0,2,1,1); }
    @FXML
    public void onButton0212clicked() { Game.playMove(0,2,1,2); }
    @FXML
    public void onButton0220clicked() { Game.playMove(0,2,2,0); }
    @FXML
    public void onButton0221clicked() { Game.playMove(0,2,2,1); }
    @FXML
    public void onButton0222clicked() { Game.playMove(0,2,2,2); }
    @FXML
    public void onButton1000clicked() { Game.playMove(1,0,0,0); }
    @FXML
    public void onButton1001clicked() { Game.playMove(1,0,0,1); }
    @FXML
    public void onButton1002clicked() { Game.playMove(1,0,0,2); }
    @FXML
    public void onButton1010clicked() { Game.playMove(1,0,1,0); }
    @FXML
    public void onButton1011clicked() { Game.playMove(1,0,1,1); }
    @FXML
    public void onButton1012clicked() { Game.playMove(1,0,1,2); }
    @FXML
    public void onButton1020clicked() { Game.playMove(1,0,2,0); }
    @FXML
    public void onButton1021clicked() { Game.playMove(1,0,2,1); }
    @FXML
    public void onButton1022clicked() { Game.playMove(1,0,2,2); }
    @FXML
    public void onButton1100clicked() { Game.playMove(1,1,0,0); }
    @FXML
    public void onButton1101clicked() { Game.playMove(1,1,0,1); }
    @FXML
    public void onButton1102clicked() { Game.playMove(1,1,0,2); }
    @FXML
    public void onButton1110clicked() { Game.playMove(1,1,1,0); }
    @FXML
    public void onButton1111clicked() { Game.playMove(1,1,1,1); }
    @FXML
    public void onButton1112clicked() { Game.playMove(1,1,1,2); }
    @FXML
    public void onButton1120clicked() { Game.playMove(1,1,2,0); }
    @FXML
    public void onButton1121clicked() { Game.playMove(1,1,2,1); }
    @FXML
    public void onButton1122clicked() { Game.playMove(1,1,2,2); }
    @FXML
    public void onButton1200clicked() { Game.playMove(1,2,0,0); }
    @FXML
    public void onButton1201clicked() { Game.playMove(1,2,0,1); }
    @FXML
    public void onButton1202clicked() { Game.playMove(1,2,0,2); }
    @FXML
    public void onButton1210clicked() { Game.playMove(1,2,1,0); }
    @FXML
    public void onButton1211clicked() { Game.playMove(1,2,1,1); }
    @FXML
    public void onButton1212clicked() { Game.playMove(1,2,1,2); }
    @FXML
    public void onButton1220clicked() { Game.playMove(1,2,2,0); }
    @FXML
    public void onButton1221clicked() { Game.playMove(1,2,2,1); }
    @FXML
    public void onButton1222clicked() { Game.playMove(1,2,2,2); }
    @FXML
    public void onButton2000clicked() { Game.playMove(2,0,0,0); }
    @FXML
    public void onButton2001clicked() { Game.playMove(2,0,0,1); }
    @FXML
    public void onButton2002clicked() { Game.playMove(2,0,0,2); }
    @FXML
    public void onButton2010clicked() { Game.playMove(2,0,1,0); }
    @FXML
    public void onButton2011clicked() { Game.playMove(2,0,1,1); }
    @FXML
    public void onButton2012clicked() { Game.playMove(2,0,1,2); }
    @FXML
    public void onButton2020clicked() { Game.playMove(2,0,2,0); }
    @FXML
    public void onButton2021clicked() { Game.playMove(2,0,2,1); }
    @FXML
    public void onButton2022clicked() { Game.playMove(2,0,2,2); }
    @FXML
    public void onButton2100clicked() { Game.playMove(2,1,0,0); }
    @FXML
    public void onButton2101clicked() { Game.playMove(2,1,0,1); }
    @FXML
    public void onButton2102clicked() { Game.playMove(2,1,0,2); }
    @FXML
    public void onButton2110clicked() { Game.playMove(2,1,1,0); }
    @FXML
    public void onButton2111clicked() { Game.playMove(2,1,1,1); }
    @FXML
    public void onButton2112clicked() { Game.playMove(2,1,1,2); }
    @FXML
    public void onButton2120clicked() { Game.playMove(2,1,2,0); }
    @FXML
    public void onButton2121clicked() { Game.playMove(2,1,2,1); }
    @FXML
    public void onButton2122clicked() { Game.playMove(2,1,2,2); }
    @FXML
    public void onButton2200clicked() { Game.playMove(2,2,0,0); }
    @FXML
    public void onButton2201clicked() { Game.playMove(2,2,0,1); }
    @FXML
    public void onButton2202clicked() { Game.playMove(2,2,0,2); }
    @FXML
    public void onButton2210clicked() { Game.playMove(2,2,1,0); }
    @FXML
    public void onButton2211clicked() { Game.playMove(2,2,1,1); }
    @FXML
    public void onButton2212clicked() { Game.playMove(2,2,1,2); }
    @FXML
    public void onButton2220clicked() { Game.playMove(2,2,2,0); }
    @FXML
    public void onButton2221clicked() { Game.playMove(2,2,2,1); }
    @FXML
    public void onButton2222clicked() { Game.playMove(2,2,2,2); }*/

}

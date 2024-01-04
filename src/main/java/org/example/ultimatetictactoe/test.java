package org.example.ultimatetictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class test {

   /* public Button button0000;
    public Button button0001;
    public Button button0002;
    public Button button0010;
    public Button button0011;
    public Button button0012;
    public Button button0020;
    public Button button0021;
    public Button button0022;

    public Button button0100;
    public Button button0101;
    public Button button0102;
    public Button button0110;
    public Button button0111;
    public Button button0112;
    public Button button0120;
    public Button button0121;
    public Button button0122;

    public Button button0200;
    public Button button0201;
    public Button button0202;
    public Button button0210;
    public Button button0211;
    public Button button0212;
    public Button button0220;
    public Button button0221;
    public Button button0222;

    public Button button1000;
    public Button button1001;
    public Button button1002;
    public Button button1010;
    public Button button1011;
    public Button button1012;
    public Button button1020;
    public Button button1021;
    public Button button1022;

    public Button button1100;
    public Button button1101;
    public Button button1102;
    public Button button1110;
    public Button button1111;
    public Button button1112;
    public Button button1120;
    public Button button1121;
    public Button button1122;

    public Button button1200;
    public Button button1201;
    public Button button1202;
    public Button button1210;
    public Button button1211;
    public Button button1212;
    public Button button1220;
    public Button button1221;
    public Button button1222;

    public Button button2000;
    public Button button2001;
    public Button button2002;
    public Button button2010;
    public Button button2011;
    public Button button2012;
    public Button button2020;
    public Button button2021;
    public Button button2022;

    public Button button2100;
    public Button button2101;
    public Button button2102;
    public Button button2110;
    public Button button2111;
    public Button button2112;
    public Button button2120;
    public Button button2121;
    public Button button2122;

    public Button button2200;
    public Button button2201;
    public Button button2202;
    public Button button2210;
    public Button button2211;
    public Button button2212;
    public Button button2220;
    public Button button2221;
    public Button button2222;*/

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

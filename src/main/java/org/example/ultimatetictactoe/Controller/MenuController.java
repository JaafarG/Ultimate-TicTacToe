package org.example.ultimatetictactoe.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.ultimatetictactoe.Main;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

public class MenuController {
    private String IPAddress;
    private int connectionPort;

    @FXML
    protected void onRulesButtonClick() {
        // Create a new stage (which will create a new window)
        Stage rulesStage = new Stage();

        // Make the rules window modal, which means it must be closed before you can interact with other windows
        rulesStage.initModality(Modality.APPLICATION_MODAL);
        rulesStage.setTitle("Game Rules");

        // Create a label that contains the rules text
        Label rulesLabel = new Label("""
                Règles du morpion classique :
                Le joueur qui commence le jeu est choisi aléatoirement et il doit remplir la grille avec des croix “X”.
                L’autre joueur, quant à lui, remplira la grille à l’aide de ronds “O”.
                Le but pour chacun des joueurs est de créer une ligne de trois signes consécutifs (croix ou ronds).
                Cette ligne peut être verticale, horizontale ou diagonale.
                            
                Règles de l’ultimate morpion :         
                L’Ultimate Morpion est un jeu bien plus complexe que le morpion classique.
                Il oppose toujours deux joueurs mais le plateau est cette fois-ci une grille de neuf cases
                comportant chacune une grille de morpion.
                Le premier joueur commence dans n’importe quelle case de n’importe lequel des petits morpions.
                Il a donc le choix entre 81 cases. Ensuite, les joueurs doivent répondre dans le petit morpion
                correspondant aux coordonnées de la case précédemment jouée par l’adversaire.
                Par exemple, si le joueur 1 joue dans le petit morpion en bas à droite et pose une croix dans la case
                en haut à gauche de ce morpion alors le joueur 2 sera tenu de jouer dans le petit morpion en haut à gauche
                mais il est libre de placer un rond dans n’importe quelle case libre de ce morpion.
                Néanmoins, si un joueur se retrouve à devoir jouer dans un petit morpion dans lequel il est impossible de jouer
                (soit par manque de case libre, soit parce que celui-ci a été remporté par un joueur)
                alors ce joueur pourra jouer sur n’importe quelle case libre sur la grille.
                Pour gagner un petit morpion, ce sont les mêmes règles que celles du morpion traditionnel expliquées plus haut.
                Si un petit morpion n’a plus de cases libres alors il est considéré comme un match nul et ne donne aucun signe
                sur le grand morpion aux deux joueurs.
                La partie se termine si un joueur aligne trois victoires sur les petits morpions, il y a donc une victoire de ce joueur
                Sinon, s'il n'y a plus de cases vides pour jouer et qu'il n'y a pas de gagnant alors la partie est se termine en égalité.                
                """);
        rulesLabel.setWrapText(true);

        // Create a VBox layout and add the label and button to it
        VBox layout = new VBox(10);
        //layout.getChildren().addAll(rulesLabel, closeButton);
        layout.getChildren().addAll(rulesLabel);
        layout.setAlignment(Pos.CENTER);

        // Create a scene containing the layout, set the scene to the stage, and show the stage
        Scene scene = new Scene(layout, 800, 600);
        rulesStage.setScene(scene);
        rulesStage.showAndWait(); // Show and wait needs to be called for modal windows
    }

    @FXML
    protected void onPlayGameButtonClick(ActionEvent event) throws IOException {
        // Retrieve the localhost IP address
        IPAddress = InetAddress.getLocalHost().getHostAddress();

        // Assign a random connection port between 1024 and 49151
        connectionPort = new Random().nextInt(48128) + 1024;

        // Load the configuration-view FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/configuration-view.fxml"));
        Parent gameViewRoot = loader.load();

        // Create the configurationController
        ConfigurationController configurationController = loader.getController();
        configurationController.updateIPAddressAndPort(IPAddress, connectionPort);

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(gameViewRoot));
        stage.show();
    }
}

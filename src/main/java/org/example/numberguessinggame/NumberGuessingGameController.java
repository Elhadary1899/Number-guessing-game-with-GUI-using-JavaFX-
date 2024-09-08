package org.example.numberguessinggame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class NumberGuessingGameController extends GameDataBase{
    @FXML
    Button level1;
    @FXML
    Button level2;
    @FXML
    Button level3;

    public void level1(ActionEvent event) throws IOException {
        FirstLevel firstLevel = new FirstLevel();
        firstLevel.playFirstLevel(event);
        playAgain(event);
    }

    public void level2(ActionEvent event) throws IOException{
        SecondLevel secondLevel = new SecondLevel();
        secondLevel.playSecondLevel(event);
        playAgain(event);
    }

    public void level3(ActionEvent event) throws IOException{
        ThirdLevel thirdLevel = new ThirdLevel();
        thirdLevel.playThirdLevel(event);
        playAgain(event);
    }



}
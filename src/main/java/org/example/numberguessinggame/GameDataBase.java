package org.example.numberguessinggame;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;

public class GameDataBase{
    private int generatedNumber;
    private int guessedNumber;
    boolean flag;
    int counter = 0;

    GameDataBase(){
        flag = true;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }

    public void setGeneratedNumber() {
        this.generatedNumber = (int) (Math.random()*10) + 1;
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }

    public void setGuessedNumber(int guessedNumber) throws InputMismatchException {
        if (guessedNumber < 1 || guessedNumber > 10) {
            String title = "Invalid number";
            String content = "Invalid number! please enter another number";
            alert(new ActionEvent(), title, content);
            this.flag = false;
        } else {
            this.guessedNumber = guessedNumber;
        }
    }

    public void playAgain(ActionEvent event) throws IOException {
        //text dialogue to see if he wants to play again
        TextInputDialog playAgainDialogue = new TextInputDialog();
        Optional<String> playAgain = null;
        try {
            // setting a guessedNumberDialogue
            playAgainDialogue.setTitle("Play Again");
            playAgainDialogue.setHeaderText("Enter \"Yes\" or \"No\"");
            playAgainDialogue.setContentText("Do you want to play again?");
            playAgain = playAgainDialogue.showAndWait();

            if(playAgain.isEmpty() || (!playAgain.get().equals("Yes") || !playAgain.get().equals("yes") || !playAgain.get().equals("YES") || !playAgain.get().equals("No") || !playAgain.get().equals("no") || !playAgain.get().equals("NO")) ){
                throw new Exception("Invalid inputs");
            }

        }catch(Exception e){
            String title = "Invalid input";
            String content = "Invalid input, please try again!";
        }

        if (playAgain.get().equals("Yes") || playAgain.get().equals("yes") || playAgain.get().equals("YES")){
        }else{
            String title = "Exit";
            String content = "Thanks for playing!";
            alert(event,title,content);
            System.exit(0);
        }
    }

    public void alert(ActionEvent event, String title, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}

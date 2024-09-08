package org.example.numberguessinggame;

import javafx.event.ActionEvent;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class SecondLevel extends GameDataBase {
    public void playSecondLevel(ActionEvent event) throws IOException {
        super.setGeneratedNumber();
        for (int i=1;i<=2;i++){
            flag = true;

            //text dialogue to input the number
            TextInputDialog guessedNumberDialogue = new TextInputDialog();
            Optional<String> guessedNumber = null;
            try {
                // setting a guessedNumberDialogue
                guessedNumberDialogue.setTitle("Guess the number");
                guessedNumberDialogue.setHeaderText("Guess a number from 1 to 10");
                guessedNumberDialogue.setContentText("Guess a number from 1 to 10: ");
                guessedNumber = guessedNumberDialogue.showAndWait();

                if(guessedNumber.isEmpty() || Integer.parseInt(guessedNumber.get())<0){
                    throw new Exception("Invalid inputs");
                }

            }catch(Exception e){
                String title = "Invalid input";
                String content = "Invalid input, please try again!";
                alert(event, title, content);
                i--;
                continue;
            }

            super.setGuessedNumber(Integer.parseInt(guessedNumber.get()));
            counter++;
            if (super.getGuessedNumber()==super.getGeneratedNumber()) {
                String title = "Well played";
                String content = "Well played, you've guessed it correct!";
                if (counter==1){
                    title += "You made it from " + counter + " trial\n";
                }else {
                    title += "You made it from " + counter + " trials\n";
                }
                alert(event, title, content);
                break;

            }else{
                if (counter < 2) {
                    if (super.getGuessedNumber() < super.getGeneratedNumber()){
                        String title = "wrong guess";
                        String content = "Wrong guess! try guessing a higher number!";
                        alert(event, title, content);
                    }else {
                        String title = "wrong guess";
                        String content = "Wrong guess! try guessing a lower number!";
                        alert(event, title, content);
                    }
                }else if (counter==2){
                    String title = "wrong guess";
                    String content = "Wrong guess! you loose:( the number was " + super.getGeneratedNumber();
                    alert(event, title, content);
                }
            }
        }

    }
}

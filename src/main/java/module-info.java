module org.example.numberguessinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.numberguessinggame to javafx.fxml;
    exports org.example.numberguessinggame;
}
module org.example.ultimatetictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ultimatetictactoe to javafx.fxml;
    exports org.example.ultimatetictactoe;
}
module org.example.ultimatetictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.ultimatetictactoe to javafx.fxml;
    exports org.example.ultimatetictactoe;

    opens org.example.ultimatetictactoe.Controller to javafx.fxml;
    exports org.example.ultimatetictactoe.Controller;
}
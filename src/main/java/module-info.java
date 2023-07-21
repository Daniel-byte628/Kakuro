module kakuro.kakuro {
    requires javafx.controls;
    requires javafx.fxml;


    opens kakuro.kakuro to javafx.fxml;


    exports kakuro.kakuro;
}
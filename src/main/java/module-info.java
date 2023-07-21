module kakuro.kakuro {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens kakuro.kakuro to javafx.fxml;
    exports kakuro.kakuro;
    exports kakuro.kakuro.Controlador;
    opens kakuro.kakuro.Controlador to javafx.fxml;

}
module com.example.projeto_finalpoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projeto_finalpoo to javafx.fxml;
    exports com.example.projeto_finalpoo to javafx.graphics;
}
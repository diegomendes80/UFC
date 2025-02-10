module com.example.projeto_finalpoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.projeto_finalpoo to javafx.fxml;
    exports com.example.projeto_finalpoo to javafx.graphics;
    exports com.example.projeto_finalpoo.controller to javafx.graphics;
    opens com.example.projeto_finalpoo.controller to javafx.fxml;
    exports com.example.projeto_finalpoo.view to javafx.graphics;
    opens com.example.projeto_finalpoo.view to javafx.fxml;
}
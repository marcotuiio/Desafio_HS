module com.example.desafio_hs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.desafio_hs to javafx.fxml;
    exports com.example.desafio_hs;
    exports com.example.desafio_hs.Controller;
    opens com.example.desafio_hs.Controller to javafx.fxml;
}
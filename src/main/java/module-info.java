module com.example.desafio_hs {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.desafio_hs to javafx.fxml;
    exports com.example.desafio_hs;
}
module com.kensoftph.combobox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kensoftph.combobox to javafx.fxml;
    exports com.kensoftph.combobox;
}
package com.kensoftph.combobox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class ComboBoxController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label selection;

    @FXML
    void loadItems(ActionEvent event) {
        loadFile();
    }

    private void loadFile(){
        try{
            File file = new File("C:\\Users\\kenth\\Desktop\\box.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String itemsFromFile;
            while((itemsFromFile = br.readLine()) != null){
                comboBox.getItems().addAll(itemsFromFile);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] items = {"Java","Programming","Language"};
        comboBox.getItems().addAll(items);

        comboBox.setOnAction(event ->{
            String data = comboBox.getSelectionModel().getSelectedItem().toString();
            selection.setText(data);

            String addItem = comboBox.getValue();
            comboBox.getItems().add(addItem);
        });
    }
}
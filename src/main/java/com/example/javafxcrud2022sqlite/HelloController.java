package com.example.javafxcrud2022sqlite;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private VBox vbox;
    RepositorioAlumnos ra;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ra=new RepositorioAlumnos();
    }


    //Crea un formulario para una clase con un textfield y un label para cada propiedad de forma automática
    public void generarFormularioDinamico(){
        HashMap<String, TextField> txtsmapa=new HashMap<>();
        ArrayList<Label> labels=new ArrayList<>();

        Alumno a=new Alumno();
        a.getClass().getName();

        for (Field f : a.getClass().getDeclaredFields()) {
            Label lbl=new Label("lbl" + f.getName());
            labels.add(lbl);
            vbox.getChildren().add(lbl);
            TextField aux=new TextField(f.getName());
            txtsmapa.put(f.getName(), aux);
            vbox.getChildren().add(aux);
        }

        Button button=new Button("Altas");
        vbox.getChildren().add(button);
        button.setOnAction(e -> {
            Alumno alumno=new Alumno();
            alumno.setNombre(txtsmapa.get("nombre").getText());
            alumno.setApellidos(txtsmapa.get("apellidos").getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, alumno.toString());
            alert.showAndWait();
        });
    }
}
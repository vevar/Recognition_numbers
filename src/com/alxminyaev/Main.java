package com.alxminyaev;

import com.alxminyaev.neuralnetwork.NeuralNet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);
        ArrayList<Integer> sizeHidden = new ArrayList<>();
        sizeHidden.add(4);
        sizeHidden.add(1);
        sizeHidden.add(3);
        NeuralNet neuralNet = new NeuralNet(3, sizeHidden, 1);
        neuralNet.print();
    }
}

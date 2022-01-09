package duckApp.ui;

import duckApp.main.ducks.Duck;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UI {
    private Duck duck;
    private final ComboBox<String> comboBox;
    private final TextArea output;

    public UI(Stage stage) {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPrefHeight(450);
        //root.setPrefHeight(Region.USE_COMPUTED_SIZE);
        root.setPrefWidth(Region.USE_COMPUTED_SIZE);
        root.setPadding(new Insets(10, 10, 10, 10));

        ImageView imageView = new ImageView();
        root.getChildren().add(imageView);

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("MallardDuck", "RubberDuck", "ModelDuck");
        comboBox.setPromptText("Choose a duck");
        root.getChildren().add(comboBox);

        Label errorLabel = new Label();
        errorLabel.textFillProperty().setValue(Color.RED);
        root.getChildren().add(errorLabel);
        errorLabel.setVisible(false);

        HBox buttonsHBox = new HBox();
        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setSpacing(10);

        Button quack = new Button("Quack");
        Button fly = new Button("Fly");
        Button swim = new Button("Swim");
        buttonsHBox.getChildren().add(quack);
        buttonsHBox.getChildren().add(fly);
        buttonsHBox.getChildren().add(swim);

        root.getChildren().add(buttonsHBox);

        output = new TextArea();
        output.setEditable(false);
        output.setMaxHeight(50);

        root.getChildren().add(output);

        stage.setTitle("Ducks!!");
        stage.setScene(scene);
        stage.show();

        //ComboBox event listener
        comboBox.setOnAction(event -> {
            String duckString = comboBox.getValue();
            try {
                Class<?> duckClass = Class.forName("duckApp.main.ducks." + duckString);
                duck = (Duck) duckClass.getConstructor().newInstance();
                imageView.setImage(new Image(duck.getImagePath(), 300, 300, true, false, false));
                errorLabel.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                errorLabel.setText(e.getMessage());
                errorLabel.setVisible(true);
            }
        });

        //Button event listeners
        quack.setOnAction(actionEvent -> {
            try {
                output.setText(duck.performQuack());
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a duck");
                errorLabel.setVisible(true);
            }
        });

        fly.setOnAction(actionEvent -> {
            try {
                output.setText(duck.performFly());
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a duck");
                errorLabel.setVisible(true);
            }
        });

        swim.setOnAction(actionEvent -> {
            try {
                output.setText(duck.swim());
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a duck");
                errorLabel.setVisible(true);
            }
        });
    }
}

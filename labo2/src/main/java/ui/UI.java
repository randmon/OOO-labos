package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import main.Cipher;

public class UI {
    private VBox root;
    private TextArea input, output;
    private ComboBox comboBox;
    private CodingContext context;

    public UI(Stage stage) {
        context = new CodingContext();
        root = new VBox();
        Scene scene = new Scene(root);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPrefHeight(Region.USE_COMPUTED_SIZE);
        root.setPrefWidth(Region.USE_COMPUTED_SIZE);
        root.setPadding(new Insets(10, 10, 10, 10));

        input = new TextArea();
        input.setPromptText("Type your text here");
        input.setMaxHeight(100);
        root.getChildren().add(input);

        comboBox = new ComboBox();
        comboBox.getItems().addAll("Caesar", "Mirror", "Morse");
        comboBox.setPromptText("Choose a cipher");
        root.getChildren().add(comboBox);

        Label errorLabel = new Label();
        errorLabel.textFillProperty().setValue(Color.RED);
        root.getChildren().add(errorLabel);
        errorLabel.setVisible(false);

        HBox buttonsHBox = new HBox();
        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setSpacing(10);

        Button encode = new Button("Encode");
        Button decode = new Button("Decode");
        buttonsHBox.getChildren().add(encode);
        buttonsHBox.getChildren().add(decode);

        root.getChildren().add(buttonsHBox);

        output = new TextArea();
        output.setEditable(false);
        output.setMaxHeight(100);

        root.getChildren().add(output);

        stage.setTitle("Ciphers!!");
        stage.setScene(scene);
        stage.show();

        //ComboBox event listener
        comboBox.setOnAction(event -> {
            String cijfer = (String) comboBox.getValue();
            try {
                Class cijferClass = Class.forName("main." + cijfer);
                Cipher cijferObject = (Cipher) cijferClass.getConstructor().newInstance();
                context.setCipher(cijferObject);
                errorLabel.setVisible(false);
            } catch (Exception e) {
                errorLabel.setText(e.getMessage());
                errorLabel.setVisible(true);
            }
        });

        //Button event listeners
        encode.setOnAction(actionEvent -> {
            try {
                output.setText(context.code(input.getText()));
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a valid cipher");
                errorLabel.setVisible(true);
            }
        });
        decode.setOnAction(actionEvent -> {
            try {
                output.setText(context.decode(input.getText()));
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a valid cipher");
                errorLabel.setVisible(true);
            }
        });
    }
}

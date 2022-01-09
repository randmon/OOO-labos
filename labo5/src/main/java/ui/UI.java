package ui;

import domain.CodingContext;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class UI {
    private final CodingContext context;

    public UI() {
        context = new CodingContext();
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());

        VBox vbox = new VBox();
        vbox.getStyleClass().add("vbox");
        root.getChildren().add(vbox);

        vbox.setAlignment(Pos.CENTER);

        TextArea input = new TextArea();
        input.setPromptText("Type your text here");
        input.setWrapText(true);
        vbox.getChildren().add(input);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(context.getCipherList());
        comboBox.setPromptText("Choose a cipher");
        vbox.getChildren().add(comboBox);

        Label errorLabel = new Label();
        vbox.getChildren().add(errorLabel);
        errorLabel.setVisible(false);

        HBox buttonsHBox = new HBox();
        vbox.getChildren().add(buttonsHBox);
        buttonsHBox.getStyleClass().add("buttonsHB");
        buttonsHBox.setAlignment(Pos.CENTER);

        Button encode = new Button("Encode");
        buttonsHBox.getChildren().add(encode);
        Button decode = new Button("Decode");
        buttonsHBox.getChildren().add(decode);


        TextArea output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        vbox.getChildren().add(output);

        Stage stage = new Stage();
        stage.setTitle("Ciphers!!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        //ComboBox event listener
        comboBox.setOnAction(event -> {
            try {
                context.setCipher(comboBox.getValue());
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

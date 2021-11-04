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

import main.CaesarCijfer;
import main.SpiegelCijfer;

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
        comboBox.getItems().addAll(
                "Caesar",
                "Mirror"
        );
        comboBox.setPromptText("Choose a cipher");
        root.getChildren().add(comboBox);

        HBox offsetHBox = new HBox();
        offsetHBox.setAlignment(Pos.CENTER);
        offsetHBox.setSpacing(10);
        offsetHBox.getChildren().add(new Label("Offset"));
        TextField offsetInput = new TextField();
        offsetInput.setPromptText("0");
        offsetInput.setMaxWidth(50);
        offsetHBox.getChildren().add(offsetInput);
        root.getChildren().add(offsetHBox);
        offsetHBox.setVisible(false);

        Label errorLabel = new Label("ERROR");
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
            Object selected = comboBox.getSelectionModel().getSelectedItem();
            offsetHBox.setVisible("Caesar".equals(selected));
        });

        //Button event listeners
        encode.setOnAction(actionEvent -> {
            try {
                String cijfer = (String) comboBox.getValue();
                if (cijfer.equals("Caesar")) {
                    context.setCijfer(new CaesarCijfer(Integer.parseInt(offsetInput.getText())));
                } else if (cijfer.equals("Mirror")) {
                    context.setCijfer(new SpiegelCijfer());
                }
                output.setText(context.code(input.getText()));
                errorLabel.setVisible(false);
            } catch (NumberFormatException nfe) {
                errorLabel.setVisible(true);
                errorLabel.setText("Please enter a valid offset!");
            }
        });

        decode.setOnAction(actionEvent -> {
            try {
                String cijfer = (String) comboBox.getValue();
                if (cijfer.equals("Caesar")) {
                    context.setCijfer(new CaesarCijfer(Integer.parseInt(offsetInput.getText())));
                } else if (cijfer.equals("Mirror")) {
                    context.setCijfer(new SpiegelCijfer());
                }
                output.setText(context.decode(input.getText()));
                errorLabel.setVisible(false);
            } catch (NumberFormatException nfe) {
                errorLabel.setVisible(true);
                errorLabel.setText("Please enter a valid offset!");
            }
        });
    }
}

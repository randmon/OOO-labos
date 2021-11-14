package view;

import controller.CipherController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CipherView {
    private VBox root;
    private TextArea output;
    private Label errorLabel;
    private CipherController controller;

    public CipherView(CipherController controller) {
        this.controller = controller;

        root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);
        root.setPrefHeight(Region.USE_COMPUTED_SIZE);
        root.setPrefWidth(Region.USE_COMPUTED_SIZE);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));


        TextArea input = new TextArea();
        input.setPromptText("Type your text here");
        input.setMaxHeight(100);
        root.getChildren().add(input);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(controller.getCipherList());
        comboBox.setPromptText("Choose a cipher");
        root.getChildren().add(comboBox);

        errorLabel = new Label();
        errorLabel.textFillProperty().setValue(Color.RED);
        root.getChildren().add(errorLabel);
        errorLabel.setVisible(false);

        HBox buttonsHBox = new HBox();
        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setSpacing(10);

        output = new TextArea();
        output.setEditable(false);
        output.setMaxHeight(100);

        root.getChildren().add(output);

        Button encode = new Button("Encode");
        Button decode = new Button("Decode");
        buttonsHBox.getChildren().add(encode);
        buttonsHBox.getChildren().add(decode);

        root.getChildren().add(buttonsHBox);

        //ComboBox event listener
        comboBox.setOnAction(event -> {
            try {
                controller.setCipher(comboBox.getValue());
                errorLabel.setVisible(false);
            } catch (Exception e) {
                errorLabel.setText(e.getMessage());
                errorLabel.setVisible(true);
            }
        });

        //Button event listeners
        encode.setOnAction(actionEvent -> {
            try {
                controller.code(input.getText());
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a valid cipher");
                errorLabel.setVisible(true);
            }
        });

        decode.setOnAction(actionEvent -> {
            try {
                controller.decode(input.getText());
            } catch (NullPointerException npe) {
                errorLabel.setText("Please select a valid cipher");
                errorLabel.setVisible(true);
            }
        });

        controller.setView(this);
    }

    public Pane getRoot() {
        return root;
    }

    public void setResult(String result) {
        output.setText(result);
    }
}

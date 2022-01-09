package view;

import controller.CipherController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CipherView extends VBox {
    private final TextArea output, input;
    private final Label errorLabel;

    public CipherView(CipherController controller) {
        controller.setView(this);
        getStyleClass().add("viewBox");
        setAlignment(Pos.CENTER);

        input = new TextArea();
        input.setPromptText("Type your text here");
        getChildren().add(input);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(controller.getCipherList());
        comboBox.setPromptText("Choose a cipher");
        getChildren().add(comboBox);

        errorLabel = new Label();
        errorLabel.getStyleClass().add("errorLabel");
        getChildren().add(errorLabel);
        errorLabel.setVisible(false);

        HBox buttonsHBox = new HBox();
        buttonsHBox.getStyleClass().add("buttonsHB");
        getChildren().add(buttonsHBox);
        buttonsHBox.setAlignment(Pos.CENTER);

        Button encode = new Button("Encode");
        buttonsHBox.getChildren().add(encode);
        Button decode = new Button("Decode");
        buttonsHBox.getChildren().add(decode);

        output = new TextArea();
        output.setEditable(false);

        getChildren().add(output);


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
    }

    public void setResult(String result) {
        output.setText(result);
    }
}

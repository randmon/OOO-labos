package view;

import controller.CipherController;
import controller.LogController;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class View {
    public View(CipherController cCtl, LogController lCtl) {
        HBox root = new HBox();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());

        root.getChildren().add(new CipherView(cCtl));
        root.getChildren().add(new LogView(lCtl));

        Stage stage = new Stage();
        stage.setTitle("Ciphers!!");
        stage.setScene(scene);
        stage.show();
    }
}

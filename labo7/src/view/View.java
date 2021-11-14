package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class View {
    private Scene scene;
    private HBox root;

    public View(Stage stage, CipherView cipherView, LogView logView) {
        root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        scene = new Scene(root);

        root.setSpacing(20);
        root.getChildren().add(cipherView.getRoot());
        root.getChildren().add(logView.getRoot());

        stage.setTitle("Ciphers!!");
        stage.setScene(scene);
        stage.show();
    }
}

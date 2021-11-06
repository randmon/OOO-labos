package duckApp.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class DuckApp  extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        new UI(stage);
    }
}

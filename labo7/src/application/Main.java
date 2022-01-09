package application;


import controller.CipherController;
import controller.LogController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CipherFacade;
import view.View;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        CipherFacade model = new CipherFacade();
        CipherController cCtl = new CipherController(model);
        LogController lCtl = new LogController(model);
        new View(cCtl, lCtl);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

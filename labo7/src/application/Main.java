package application;


import controller.CipherController;
import controller.LogController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CipherFacade;
import view.CipherView;
import view.LogView;
import view.View;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        CipherFacade model = new CipherFacade();

        //Cipher view
        CipherController cCtrl = new CipherController(model);
        CipherView cView = new CipherView(cCtrl);

        //Log view
        LogController lCtrl = new LogController(model);
        LogView lView = new LogView(lCtrl);

        new View(stage, cView, lView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

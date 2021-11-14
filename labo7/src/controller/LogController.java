package controller;

import javafx.scene.paint.Color;
import model.CipherFacade;
import view.LogView;

import java.util.Observable;
import java.util.Observer;

public class LogController implements Observer {
    private CipherFacade model;
    private LogView view;

    public LogController(CipherFacade model){
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(LogView logView) {
        this.view = logView;
    }

    @Override
    public void update(Observable o, Object arg) {
        String[] args = (String[]) arg;
        String result = String.join(" - ", args);
        Color color = args[0].equals("coded") ? Color.BLUE : Color.GREEN;
        view.updateDisplay(result, color);
    }
}

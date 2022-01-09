package controller;

import model.CipherEvent;
import model.CipherFacade;
import view.LogView;

public class LogController implements Observer {
    private final CipherFacade model;
    private LogView view;

    public LogController(CipherFacade model){
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(LogView logView) {
        this.view = logView;
    }

    @Override
    public void update(CipherEvent event) {
        String result = event.getName() + " - " + model.getCipherName() + " - " + model.getInput() + " - " + model.getOutput();
        String s = event.equals(CipherEvent.CODE) ? "code" : "decode";
        view.updateDisplay(result, s);
    }
}

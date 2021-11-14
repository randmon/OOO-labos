package controller;

import model.CipherFacade;
import view.CipherView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CipherController implements Observer {
    private CipherFacade model;
    private CipherView view;

    public CipherController(CipherFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    // Methods called by the view
    public void setView(CipherView cipherView) {
        this.view = cipherView;
    }

    public void code(String text) {
        model.code(text);
    }

    public void decode(String text) {
        model.decode(text);
    }

    public List<String> getCipherList() {
        return model.getCipherList();
    }

    public void setCipher(String cipher) {
        model.setCipher(cipher);
    }


    // Method called by the model
    @Override
    public void update(Observable o, Object arg) {
        view.setResult(((String[]) arg)[2]);
    }
}

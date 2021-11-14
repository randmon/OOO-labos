package model;

import model.ciphers.CipherEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CipherFacade extends Observable {
    private final CipherContext context;
    private String cipher;

    public CipherFacade() {
        this.context = new CipherContext();
    }

    public void setCipher(String cipher) {
        context.setCipher(CipherFactory.getCipher(cipher));
        this.cipher = cipher;
    }

    public void code(String text) {
        String output = context.code(text);
        setChanged();
        notifyObservers(new String[] {"coded", text, output, cipher});
    }

    public void decode(String text) {
        String output = context.decode(text);
        setChanged();
        notifyObservers(new String[] {"decoded", text, output, cipher});
    }

    public List<String> getCipherList() {
        List<String> ciphers = new ArrayList<>();
        for (CipherEnum c : CipherEnum.values()) {
            ciphers.add(c.getName());
        }
        return ciphers;
    }
}

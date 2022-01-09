package model;

import model.ciphers.CipherEnum;

import java.util.ArrayList;
import java.util.List;

public class CipherFacade extends Observable {
    private final CipherContext context;
    private String input, output, cipher;

    public CipherFacade() {
        this.context = new CipherContext();
    }

    public void setCipher(String cipherName) {
        cipher = cipherName;
        context.setCipher(CipherFactory.getCipher(cipherName));
    }

    public void code(String text) {
        input = text;
        output = context.code(text);
        notifyObservers(CipherEvent.CODE);
    }

    public void decode(String text) {
        input = text;
        output = context.decode(text);
        notifyObservers(CipherEvent.DECODE);
    }

    public List<String> getCipherList() {
        List<String> ciphers = new ArrayList<>();
        for (CipherEnum c : CipherEnum.values()) {
            ciphers.add(c.getName());
        }
        return ciphers;
    }

    public String getOutput() {
        return output;
    }

    public String getInput() {
        return input;
    }

    public String getCipherName() {
        return cipher;
    }
}

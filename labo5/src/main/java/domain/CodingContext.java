package domain;

import domain.ciphers.Cipher;

import java.util.ArrayList;
import java.util.List;

/**Context class*/
public class CodingContext {
    private Cipher cipher;

    /**Behaviour is interchangeable at runtime*/
    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setCipher(String name) {
        setCipher(CipherFactory.getCipher(name));
    }

    public Cipher getCipher() {
        return cipher;
    }

    public String code(String s) {
        return cipher.code(s);
    }
    public String decode(String s) {
        return cipher.decode(s);
    }

    public List<String> getCipherList() {
        List<String> ciphers = new ArrayList<>();
        for (CipherEnum c : CipherEnum.values()) {
            ciphers.add(c.getName());
        }
        return ciphers;
    }
}
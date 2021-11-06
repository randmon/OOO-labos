package cipherApp.ui;

import cipherApp.main.Cipher;

/**Context class*/
public class CodingContext {
    private Cipher cipher;

    /**Behaviour is interchangeable at runtime*/
    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String code(String s) {
        return cipher.code(s);
    }
    public String decode(String s) {
        return cipher.decode(s);
    }
}

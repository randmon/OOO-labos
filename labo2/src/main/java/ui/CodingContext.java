package ui;

import main.Cipher;

/**Context class*/
public class CodingContext {
    public Cipher cipher;

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

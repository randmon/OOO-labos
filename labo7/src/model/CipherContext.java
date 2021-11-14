package model;

import model.ciphers.Cipher;

public class CipherContext{
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

    public Cipher getCipher() {
        return cipher;
    }
}

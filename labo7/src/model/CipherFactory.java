package model;

import model.ciphers.Cipher;
import model.ciphers.CipherEnum;

public class CipherFactory {
    public static Cipher getCipher(String name) {
        CipherEnum ciphers = CipherEnum.valueOf(name.toUpperCase());
        String className = ciphers.getClassName();
        try {
            Class<?> cipherClass = Class.forName(className);
            return (Cipher) cipherClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid cipher");
        }
    }
}

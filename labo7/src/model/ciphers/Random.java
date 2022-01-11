package model.ciphers;

import domain.RandomCypher;

public class Random implements Cipher {
    private final RandomCypher randomCypher;

    public Random() {
        randomCypher = new RandomCypher();
    }

    @Override
    public String code(String text) {
        String s = text.toLowerCase().replaceAll("[^a-zA-Z]","");
        return String.valueOf(randomCypher.encypher(s.toCharArray()));
    }

    @Override
    public String decode(String secret) {
        String s = secret.toLowerCase().replaceAll("[^a-zA-Z]","");
        return String.valueOf(randomCypher.decypher(s.toCharArray()));
    }
}

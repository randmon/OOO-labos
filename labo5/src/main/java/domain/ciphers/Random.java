package domain.ciphers;

import java.util.HashMap;
import java.util.Map;

public class Random implements Cipher {
    private final Map<Character, Character> codes = new HashMap<>();

    public Random() {
        codes.put('a', 'f');
        codes.put('b', 'n');
        codes.put('c', 'd');
        codes.put('d', 'v');
        codes.put('e', 'g');
        codes.put('f', 'x');
        codes.put('g', 'z');
        codes.put('h', 'o');
        codes.put('i', 'l');
        codes.put('j', 'r');
        codes.put('k', 'u');
        codes.put('l', 'a');
        codes.put('m', 'k');
        codes.put('n', 'i');
        codes.put('o', 's');
        codes.put('p', 'e');
        codes.put('q', 'x');
        codes.put('r', 'p');
        codes.put('s', 'b');
        codes.put('t', 'y');
        codes.put('u', 'm');
        codes.put('v', 'h');
        codes.put('w', 'w');
        codes.put('x', 't');
        codes.put('y', 'q');
        codes.put('z', 'j');
    }

    @Override
    public String code(String text) {
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()) {
            Character c2 = codes.get(c);
            if (c2 != null) {
                result.append(c2);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public String decode(String secret) {
        StringBuilder result = new StringBuilder();
        for(char c : secret.toCharArray()) {
            result.append(getChar(c));
        }
        return result.toString();
    }

    private char getChar(char c) {
        for (Map.Entry<Character, Character> e : codes.entrySet()) {
            if (e.getValue() == c) {
                return e.getKey();
            }
        }
        return c;
    }
}

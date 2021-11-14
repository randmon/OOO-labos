package model.ciphers;

public class Morse implements Cipher {
    private String[] morseCode
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };

    @Override
    public String code(String text) {
        char[] letters = text.toUpperCase().toCharArray();
        StringBuilder result = new StringBuilder();
        for (char l : letters) {
            char start = 'A';
            if (l == ' ') {
                result.append(" | "); //Use | in morse as a space in plaintext
            } else {
                try {
                    result.append(morseCode[l - start]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    result.append(l);
                }
                result.append(" ");
            }
        }
        return result.toString();
    }

    @Override
    public String decode(String secret) {
        StringBuilder result = new StringBuilder();
        String[] letters = secret.split(" ");
        for (String l : letters) {
            if (l.equals("|")) result.append(" ");
            else {
                boolean found = false;
                for (int i = 0; i < morseCode.length; i++) {
                    if (l.equals(morseCode[i])) {
                        result.append((char) ('A' + i));
                        found = true;
                        break;
                    }
                }
                if (!found) result.append(l);
            }
        }
        return result.toString();
    }
}
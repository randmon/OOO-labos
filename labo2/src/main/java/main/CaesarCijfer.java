package main;

public class CaesarCijfer implements Cijfer {
    private final int offset;

    public CaesarCijfer(int offset) {
        this.offset = offset;
    }

    @Override
    public String code(String text) {
        return applyOffset(text, offset);
    }

    @Override
    public String decode(String text) {
        return applyOffset(text, -offset);
    }

    private String applyOffset(String text, int offset) {
        if (text == null) throw new IllegalArgumentException("Text cannot be empty");

        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char start = 'a';
                char end = 'z';
                if (Character.isUpperCase(character)) {
                    start = 'A';
                    end = 'Z';
                }
                char newChar = (char) (((int) character + offset - start) % 26 + start);
                if (newChar < start) newChar = (char) (end - (start - newChar) + 1); // Loop around
                result.append(newChar);
            } else {
                result.append(character);
            }
        }
        return String.valueOf(result);
    }
}

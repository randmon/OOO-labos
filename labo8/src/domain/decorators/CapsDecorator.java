package domain.decorators;

import domain.LetterLezer;

public class CapsDecorator extends LetterLezerDecorator {
    private char previousLetter;

    public CapsDecorator(LetterLezer letterLezer) {
        super(letterLezer);
        previousLetter = ' '; //First letter is always uppercase
    }

    @Override
    public char leesLetter() {
        char letter = letterLezer.leesLetter();
        //Letter after a space is upper case
        if (previousLetter == ' ') letter = Character.toUpperCase(letter);
        previousLetter = letter;
        return letter;
    }
}

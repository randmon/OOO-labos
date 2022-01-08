package domain.decorators;

import domain.LetterLezer;

public class SpacesBetweenDecorator extends LetterLezerDecorator {
    private boolean spaced;

    public SpacesBetweenDecorator(LetterLezer letterLezer) {
        super(letterLezer);
        spaced = true; //Don't insert space before first letter
    }

    @Override
    public char leesLetter() {
        char letter = ' ';
        if (spaced) letter = letterLezer.leesLetter();
        spaced = !spaced;
        return letter;
    }
}

package domain.decorators;

import domain.LetterLezer;

public class RemoveSpaceDecorator extends LetterLezerDecorator {
    public RemoveSpaceDecorator(LetterLezer letterLezer) {
        super(letterLezer);
    }

    @Override
    public char leesLetter() {
        char letter = letterLezer.leesLetter();
        //If char is a space, skip to the next letter
        while (letter == ' ') letter = letterLezer.leesLetter();
        return letter;
    }
}

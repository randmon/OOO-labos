package domain.decorators;

import domain.LetterLezer;

public abstract class LetterLezerDecorator extends LetterLezer {
    protected final LetterLezer letterLezer;

    public LetterLezerDecorator(LetterLezer letterLezer) {
        this.letterLezer = letterLezer;
    }
}

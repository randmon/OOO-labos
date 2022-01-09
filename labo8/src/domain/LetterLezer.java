package domain;

//This is the abstract component class
public abstract class LetterLezer {
    private String tekst;
    private int index = 0;

    public char leesLetter() {
        if (index < tekst.length()) {
            return tekst.charAt(index++);
        }
        return '*';
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}

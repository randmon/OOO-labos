import domain.FileLetterLezer;
import domain.LetterLezer;
import domain.TekstLetterLezer;
import domain.decorators.CapsDecorator;
import domain.decorators.RemoveSpaceDecorator;
import domain.decorators.SpacesBetweenDecorator;

public class App {
    public static void main (String [] args){
        LetterLezer fileLezer = new FileLetterLezer("src/letters.txt");
        fileLezer = new RemoveSpaceDecorator(fileLezer);
        fileLezer = new CapsDecorator(fileLezer);
        fileLezer = new SpacesBetweenDecorator(fileLezer);
        read(fileLezer);

        LetterLezer tekstLezer = new TekstLetterLezer("Dit is een zin");
        tekstLezer = new CapsDecorator(tekstLezer);
        tekstLezer = new RemoveSpaceDecorator(tekstLezer);
        read(tekstLezer);
    }

    public static void read(LetterLezer lezer) {
        char letter = lezer.leesLetter();
        while (letter != '*'){
            System.out.print(letter);
            letter = lezer.leesLetter();
        }
        System.out.println();
    }
}

package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLetterLezer extends LetterLezer {
    public FileLetterLezer(String fileNaam) {
        try {
            Scanner scanner = new Scanner(new File(fileNaam));
            setTekst(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            setTekst("??");
        }
    }

}

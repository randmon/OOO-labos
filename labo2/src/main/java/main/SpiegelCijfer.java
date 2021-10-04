package main;

public class SpiegelCijfer extends Cijfer {

    public String coderen(String text) {
        return decoderen(text);
    }

    public String decoderen(String geheim) {
        return String.valueOf(new StringBuilder().append(geheim).reverse());
    }
}

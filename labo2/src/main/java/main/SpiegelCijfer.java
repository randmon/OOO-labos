package main;

public class SpiegelCijfer implements Cijfer {

    public String code(String text) {
        return decode(text);
    }

    public String decode(String geheim) {
        return String.valueOf(new StringBuilder().append(geheim).reverse());
    }
}

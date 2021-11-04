package ui;


import main.Cijfer;

public class CodingContext {
    public Cijfer cijfer;

    public void setCijfer(Cijfer cijfer) {
        this.cijfer = cijfer;
    }

    public String code(String s) {
        return cijfer.code(s);
    }
    public String decode(String s) {
        return cijfer.decode(s);
    }
}

package model;

public enum CipherEvent {
    CODE("Code"), DECODE("Decode");

    private final String name;

    CipherEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

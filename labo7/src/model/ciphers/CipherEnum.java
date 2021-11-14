package model.ciphers;

/**When adding a new cipher, the only thing that needs to change in the rest of the code is to add an enum line here*/
public enum CipherEnum {
    CAESAR("Caesar"),
    MIRROR("Mirror"),
    MORSE("Morse"),
    RANDOM("Random");

    private final String name;

    CipherEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return "model.ciphers." + name;
    }
}

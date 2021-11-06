package duckApp.main.behaviours;

public class NoFly implements FlyBehaviour {
    @Override
    public String fly() {
        return "I can't fly!";
    }
}

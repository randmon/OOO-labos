package duckApp.main.ducks;

import duckApp.main.behaviours.FlyBehaviour;
import duckApp.main.behaviours.QuackBehaviour;

public abstract class Duck {
    private String imagePath;
    private QuackBehaviour quackBehaviour;
    private FlyBehaviour flyBehaviour;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public String performQuack() {
        return quackBehaviour.quack();
    }

    public String performFly() {
        return flyBehaviour.fly();
    }

    public String swim() {
        return "I am swimming";
    }
}

package duckApp.main.ducks;

import duckApp.main.behaviours.FlyWithWings;
import duckApp.main.behaviours.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehaviour(new FlyWithWings());
        setQuackBehaviour(new Quack());
        setImagePath("https://animals.net/wp-content/uploads/2018/07/Mallard-1-650x425.jpg");
    }
}

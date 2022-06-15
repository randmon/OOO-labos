package duckApp.main.ducks;

import duckApp.main.behaviours.FlyWithWings;
import duckApp.main.behaviours.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehaviour(new FlyWithWings());
        setQuackBehaviour(new Quack());
        setImagePath("https://www.allaboutbirds.org/guide/assets/photo/308743051-480px.jpg");
    }
}

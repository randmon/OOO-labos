package duckApp.main.ducks;

import duckApp.main.behaviours.NoFly;
import duckApp.main.behaviours.NoQuack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehaviour(new NoFly());
        setQuackBehaviour(new NoQuack());
        setImagePath("https://cdn20.pamono.com/p/s/7/1/714913_a9ph9l5tsd/antique-handmade-wooden-duck.jpg");
    }
}

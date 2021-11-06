package duckApp.main.ducks;

import duckApp.main.behaviours.NoFly;
import duckApp.main.behaviours.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setQuackBehaviour(new Squeak());
        setFlyBehaviour(new NoFly());
        setImagePath("https://i.guim.co.uk/img/media/a5fb31e646d2677f9d44104a3b26ee42955f0acc/0_170_5100_3059/master/5100.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=aa3e8bddfcc681ae45c2d642734ccdbc");
    }
}

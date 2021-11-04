package domain.states;

public class RentedState implements ProductState {
    @Override
    public void setAvailable(StateContext context) {
        context.setProductState(new AvailableState());
    }

    @Override
    public void damage(StateContext context) {
        context.setProductState(new DamagedState());
    }

    @Override
    public String toString() {
        return "Rented";
    }
}

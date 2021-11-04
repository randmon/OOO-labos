package domain.states;

public class AvailableState implements ProductState {
    @Override
    public void rent(StateContext context) {
        context.setProductState(new RentedState());
    }

    @Override
    public void remove(StateContext context) {
        context.setProductState(new RemovedState());
    }

    @Override
    public String toString() {
        return "Available";
    }
}

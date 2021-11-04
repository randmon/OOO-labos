package domain.states;

public class DamagedState implements ProductState {
    @Override
    public void fixDamage(StateContext context) {
        context.setProductState(new AvailableState());
    }

    @Override
    public void remove(StateContext context) {
        context.setProductState(new RemovedState());
    }

    @Override
    public String toString() {
        return "Damaged";
    }
}

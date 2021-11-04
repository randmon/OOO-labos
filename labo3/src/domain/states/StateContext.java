package domain.states;

public class StateContext {
    private ProductState state;
    public StateContext() {
        state = new AvailableState();
    }

    public void setProductState(ProductState state) {
        this.state = state;
    }

    public ProductState getState() {
        return state;
    }
}

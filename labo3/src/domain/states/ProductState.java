package domain.states;

public interface ProductState {
    default void rent(StateContext context) {
        throw new IllegalArgumentException("Product cannot be Rented because it is " + context.getState());
    }
    default void setAvailable(StateContext context) {
        throw new IllegalArgumentException("Product cannot be Available because it is " + context.getState());
    }

    default void damage(StateContext context) {
        throw new IllegalArgumentException("Product cannot be Damaged because it is " + context.getState());
    }

    default void fixDamage(StateContext context) {
        throw new IllegalArgumentException("Product cannot be Fixed because it is " + context.getState());
    }

    default void remove(StateContext context) {
        throw new IllegalArgumentException("Product cannot be Removed because it is " + context.getState());
    }

    @Override
    String toString();
}

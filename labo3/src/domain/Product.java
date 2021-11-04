package domain;

import domain.states.*;

public abstract class Product {
    private final int id;
    private final String title;
    private final StateContext context;

    public Product(int id, String title) {
        this.id = id;
        this.title = title;
        boolean available = true;
        context = new StateContext();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getPrice(int days);

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTitle: " + title +
                "\nState: " + context.getState();
    }

    public void setState(String state) {
        switch (state) {
            case "Rented" -> context.setProductState(new RentedState());
            case "Available" -> context.setProductState(new AvailableState());
            case "Damaged" -> context.setProductState(new DamagedState());
            case "Removed" -> context.setProductState(new RemovedState());
        }
    }

    public void rent() {
        context.getState().rent(context);
    }

    public void setAvailable() {
        context.getState().setAvailable(context);
    }

    public void setDamaged() {
        context.getState().damage(context);
    }

    public void fixDamage() {
        context.getState().fixDamage(context);
    }

    public void setRemoved() {
        context.getState().remove(context);
    }
}

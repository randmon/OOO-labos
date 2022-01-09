package view;

import controller.LogController;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LogView extends VBox {
    private final VBox list;

    public LogView(LogController controller) {
        controller.setView(this);
        getStyleClass().add("viewBox");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        getChildren().add(scrollPane);

        list = new VBox();
        list.getStyleClass().add("logList");
        scrollPane.setContent(list);

    }

    public void updateDisplay(String entry, String event) {
        Label lb = new Label(entry);
        lb.getStyleClass().add(event);
        list.getChildren().add(lb);
    }
}

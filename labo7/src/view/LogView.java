package view;

import controller.LogController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LogView {
    private final VBox root;
    private final ScrollPane scrollPane;
    private VBox list;

    public LogView(LogController controller) {
        root = new VBox();
        root.setPrefWidth(500);

        scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        root.getChildren().add(scrollPane);

        list = new VBox(10);
        list.setPadding(new Insets(10, 10, 10, 10));
        list.setPrefWidth(root.getPrefWidth()-20);
        scrollPane.setContent(list);

        controller.setView(this);
    }

    public Pane getRoot() {
        return root;
    }

    public void updateDisplay(String entry, Color color) {
        Label lb = new Label(entry);
        lb.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, null, new BorderWidths(0, 0, 1, 0))));
        lb.setPrefWidth(list.getPrefWidth());
        list.getChildren().add(lb);
    }
}

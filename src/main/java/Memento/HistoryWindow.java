package Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryWindow extends Application {
    private Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("History");

        ListView<String> listView = new ListView<>();
        for (IMemento memento : controller.getHistory()) {
            listView.getItems().add(memento.getMetaData());
        }

        listView.setOnMouseClicked(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                controller.restoreStateFromHistory(selectedIndex);
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

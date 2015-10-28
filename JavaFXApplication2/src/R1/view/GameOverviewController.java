package R1.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import R1.MainApp;
import R1.model.Game;
import java.time.LocalDateTime;
import javafx.scene.control.Button;

public class GameOverviewController {

    @FXML
    private TableView<Game> gameTable;

    @FXML
    private TableColumn<Game, LocalDateTime> dateTime;

    @FXML
    private TableColumn<Game, String> player;

    @FXML
    private TableColumn<Game, Button> playButton;

    @FXML
    private TableColumn<Game, Button> editButton;

    private MainApp mainApp;

    public GameOverviewController() {

    }

    @FXML
    private void initialize() {
        editButton.setCellValueFactory(cellData -> cellData.getValue().editButton());
        playButton.setCellValueFactory(cellData -> cellData.getValue().playButton());
        dateTime.setCellValueFactory(cellData -> cellData.getValue().dateTime());
        player.setCellValueFactory(cellData -> cellData.getValue().playerProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        gameTable.setItems(mainApp.gameList());
    }
}

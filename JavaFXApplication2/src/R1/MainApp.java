package R1;

import R1.model.Game;
import R1.view.GameOverviewController;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Game> gameList = FXCollections.observableArrayList();    
    private HashMap<String,List> playerList1 = new HashMap<String, List>();
    private HashMap<String,List> playerList2 = new HashMap<String, List>();
    
    
    
    public MainApp() {
        playerList1.put("korak@mail.de", new ArrayList<>(Arrays.asList(false)));
        playerList1.put("4nges@mail.de", new ArrayList<>(Arrays.asList(false)));
        
        playerList2.put("lisbeth@gmail.com", new ArrayList<>(Arrays.asList(false)));
        playerList2.put("anette@aol.de", new ArrayList<>(Arrays.asList(false)));
        
        gameList.add(new Game("korak@mail.de",1,1,"Hubis Kegelkeller",4,LocalDate.of(2014, 12, 12),LocalTime.now(),playerList1));
        gameList.add(new Game("anette@aol.de",2,-1,"Ronnys reudiger Laden",1,LocalDate.of(2015, 1, 12),LocalTime.now(),playerList2));
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Kegel-App 5000 in Farbe");

        initRootLayout();

        showGameOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showGameOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GameOverview.fxml"));
            SplitPane gameOverview = (SplitPane) loader.load();
            
            rootLayout.setCenter(gameOverview);
            
            GameOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public ObservableList<Game> gameList() {
        return gameList;
    }
}
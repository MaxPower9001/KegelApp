/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spike.view;

import spike.MainApp;
import javafx.fxml.FXML;

/**
 *
 * @author Rene
 */
public class RootLayoutController {
    private MainApp mainApp;
    
        /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public RootLayoutController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    
    /**
     * Called when the user clicks the Close buttin. Closes the App. 
     */
    @FXML
    private void handleCloseApp() throws Exception {
        this.mainApp.stop();
    }
    
}

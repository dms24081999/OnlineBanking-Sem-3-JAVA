/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinebanking;

import database.DBConnected;

import database.SqliteConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle; //StageStyle.DECORATED

/**
 *
 * @author dms
 */
public class OnlineBanking extends Application {
    Stage stage;
    Connection connection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        mainWindow();
    }
    public void mainWindow() throws IOException {
        connection = SqliteConnection.createdb();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/onlinebanking/login/LoginPage.fxml"));
        AnchorPane pane=loader.load();
        Scene scene=new Scene(pane);
        scene.getStylesheets().addAll(getClass().getResource("/onlinebanking/login/style.css").toExternalForm());
        
        stage.setTitle("Online Banking");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DBConnected dbConnected = new DBConnected();
        launch(args);
    }
    
}

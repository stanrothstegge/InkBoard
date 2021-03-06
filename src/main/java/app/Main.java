package main.java.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/***
 * Main Programma
 *
 *
 * @Author Stan Rothstegge
 */
public class Main extends Application {
    //private Logger logger = LoggerFactory.getLogger(Wombat.class);
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/java/fx/view/UI/splash.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

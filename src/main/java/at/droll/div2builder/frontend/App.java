package at.droll.div2builder.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * div2builder frontend based upon JavaFX
 */
public class App extends Application {

    private static Scene scene;

//    /**
//     * Overwritten initialize method for every scene 
//     */
//    @Override
//    public void init() throws Exception {
//    	
//    	// TODO Multi language support
////    	Locale supportedLocales[] = { Locale.GERMAN, Locale.ENGLISH };
////    	ResourceBundle labels = ResourceBundle.getBundle(
////    			App.class.getResource("language/Translation").toExternalForm(),
////    			Locale.getDefault(),
////    			this.getClass().getClassLoader()
////    	);
//    	
//    	super.init();
//    }
    
    
    /**
     * Start method. It's execued during the javafx life cycle from the launch method.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 1280, 810);
        scene.getStylesheets().add(App.class.getResource("assets/div2builder.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("div2builder");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResource("assets/logo.png").toExternalForm()));
        stage.show();
    }

    /**
     * Sets the root of the scene
     * @param fxml
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Load the passed fxml resource
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main method for the javafx appplication
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}
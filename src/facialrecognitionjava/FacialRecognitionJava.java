/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facialrecognitionjava;


import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nicholas
 */
public class FacialRecognitionJava extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FaceRecognitionUI.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        if (os.toUpperCase().contains("LINUX")) {
            File lib = new File("libs/" + System.mapLibraryName("opencv_java331"));     
            System.out.println(lib.getAbsolutePath());
            System.load(lib.getAbsolutePath());
        }  else if (os.toUpperCase().contains("MAC OS X")) {
            File lib = new File("libs/" + System.mapLibraryName("opencv_java331"));     
            System.out.println(lib.getAbsolutePath());
            System.load(lib.getAbsolutePath());
        } 
        System.out.println(System.getProperty("os.name"));

        launch(args);
    }
    
}

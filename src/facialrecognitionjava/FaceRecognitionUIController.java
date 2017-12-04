/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialrecognitionjava;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

/**
 * FXML Controller class
 *
 * @author nicholas
 */
public class FaceRecognitionUIController implements Initializable {
    @FXML
    private ImageView currentFrame;
    
    private ScheduledExecutorService timer;
    private VideoCapture capture = new VideoCapture();
    private static int cameraId = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.currentFrame = new ImageView();
        
        this.capture.open(cameraId);
        
        if (this.capture.isOpened()) {
            Runnable frameGrabber = new Runnable() {		
                @Override
		public void run() {
                    Mat frame = grabFrame();
                    MatOfByte buffer = new MatOfByte();
                    Imgcodecs.imencode(".png", frame, buffer);
                    Image imageToShow = new Image(new ByteArrayInputStream(buffer.toArray()));
                    Platform.runLater(() -> {
			currentFrame.imageProperty().set(imageToShow);
                    });
		  
		}
            };
				
            this.timer = Executors.newSingleThreadScheduledExecutor();
            this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
        }
    }   
    
    private Mat grabFrame() {
	Mat frame = new Mat();
		
	if (this.capture.isOpened()) {
            try {
		this.capture.read(frame);
                if (!frame.empty()) {
                    //Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
		}
            } catch (Exception e) {
		System.err.println("Exception during the image elaboration: " + e);
            }
	}
		
        return frame;
    }
}

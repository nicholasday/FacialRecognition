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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.core.Core;
import org.opencv.objdetect.CascadeClassifier;

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
        this.capture.open(cameraId);
        
        if (this.capture.isOpened()) {
            Runnable frameGrabber = new Runnable() {		
                @Override
		public void run() {
                    Mat frame = grabFrame();
                    MatOfByte buffer = new MatOfByte();
                    Imgcodecs.imencode(".png", frame, buffer);
                    Image imageToShow = new Image(new ByteArrayInputStream(buffer.toArray()));
                    currentFrame.setImage(imageToShow);		  
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
                    frame = showFaces(frame);
                    
                    //Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
		}
            } catch (Exception e) {
		System.err.println("Exception during the image elaboration: " + e);
            }
	}
		
        return frame;
    }
    
    public Mat showFaces(Mat img) {
        Mat gray = new Mat();
        Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
        System.out.println("i");
        CascadeClassifier faceDetector = new CascadeClassifier(getClass().getClassLoader().getResource("resources/lbpcascade_frontalface.xml").getPath());
        System.out.println("j");
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(img, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        return img;
    }
    
    public Mat showCroppedFace(Mat img) {
        Mat gray = new Mat();
        Mat cropped = new Mat();
        Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
        System.out.println("i");
        CascadeClassifier faceDetector = new CascadeClassifier(getClass().getClassLoader().getResource("resources/lbpcascade_frontalface.xml").getPath());
        System.out.println("j");
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(img, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
             cropped = img.submat(new Rect(rect.x - 1, rect.y - 1, rect.x + rect.width + 1, rect.y + rect.height + 1));

        }

        return cropped;
    }
}

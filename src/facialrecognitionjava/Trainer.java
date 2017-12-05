/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialrecognitionjava;

import java.io.File;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author nicholas
 */
public class Trainer {
    public static void getAverageFace() {
        File[] currentDirectory = new File("./faces").listFiles();
        Mat sum = new Mat(200, 180, CvType.CV_64FC1);
        for(File f : currentDirectory){
            if(f.isFile()){
                System.out.println(f.getName());
                Mat image = Imgcodecs.imread("./faces" + f.getName());
                Imgproc.accumulate(sum, sum, image);
            }
        }
        Core.multiply(sum, new Scalar(1.0/currentDirectory.length), sum);
        Imgcodecs.imwrite("test.png", sum);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialrecognitionjava;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import java.io.File;

/**
 *
 * @author nicholas
 */
public class FacialRecognitionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        if (os.toUpperCase().contains("LINUX")) {
            File lib = new File("libs/" + System.mapLibraryName("opencv_java331"));     
            System.out.println(lib.getAbsolutePath());
            System.load(lib.getAbsolutePath());
        }

        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
        // TODO code application logic here
    }
    
}

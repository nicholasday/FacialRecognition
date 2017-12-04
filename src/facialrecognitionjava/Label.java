/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialrecognitionjava;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
/**
 *
 * @author moham
 */
public class Label {
    private double x, y;
    private String text;
    private Scalar color;
    private int size;
    
    public Label(double x, double y, String text, Scalar color, int size) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.color = color;
        this.size = size;
    }
}

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
//class for drawing labels onto OpenCV Mats
public class Label {
    private double x, y;
    private String text;
    private Scalar color;
    private int size;
    
    //label constructor
    public Label(double x, double y, String text, Scalar color, int size) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.color = color;
        this.size = size;
    }
    
    //draws label onto Mat
    public Mat draw(Mat mat) {        
        Imgproc.putText(mat, text, new Point(this.x, this.y), 3, 3, new Scalar(255, 255, 255));
        return mat;
    }
    
     public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Scalar getColor() {
        return color;
    }

    public void setColor(Scalar color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

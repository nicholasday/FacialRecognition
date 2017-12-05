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

//class for drawing buttons onto our OpenCV Mats
public class Button {
    
    private double x, y, width, height;
    private String text;
    private Scalar color;
    
    //button constructor
    public Button(double x, double y, String text, double width, double height, Scalar color) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    //draws button with text
    public Mat draw(Mat mat) {        
        Imgproc.rectangle(mat, new Point(this.x, this.y), new Point(this.x + this.width, this.y + this.height), color);
        Imgproc.putText(mat, text, new Point(this.x + 10, this.y + this.height - 10), 3, 3, new Scalar(255, 255, 255));
        return mat;
    }

    //uses click information from JavaFX to return boolean of whether button was clicked or not
    public boolean isColliding(double clickX, double clickY) {
    
        if ((this.x < clickX && clickX < (this.x + this.width)) && (this.y < clickY && clickY < (this.y + this.height))) {
            return true;
        }
        return false;
        
    }
    
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
    
}

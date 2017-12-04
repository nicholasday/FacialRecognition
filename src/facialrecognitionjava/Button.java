/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialrecognitionjava;

import org.opencv.core.Mat;

/**
 *
 * @author moham
 */
public class Button {
    
    private int x, y, width, height;
    private String text;
    
    public Button(int x, int y, String text, int width, int height) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.width = width;
        this.height = height;
    }
    
    public void draw(Mat mat) {
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
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
    
    
}

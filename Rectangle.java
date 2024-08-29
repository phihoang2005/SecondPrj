/*
 *@ (#) Rectangle.java     1.0  8/29/2024
 *Copyright (c) 2024 IUH  . All right reserved.
 */

package iuh.fit.se;

/*
 *@description: tinh chu vi va dien tich HCN
 *@author:Nguyen Tran Phi Hoang
 *@date:    8/29/2024
 *version:  1.0
 */
public class Rectangle {
    private double length;
    private double width;

    //phuong thuc
    public double getArea () {
        return length * width;
    }
    public double getPerimeter () {
        return 2 * length + 2 * width;
    }

    //get
    public double getLength () {
        return length;
    }

    public double getWidth () {
        return width;
    }

    //constructor
    public Rectangle() {
        length = 0.0;
        width = 0.0;
    }
    public Rectangle( double length, double width){

        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0");
        }
        this.length = length;
        this.width = width;
    }


    //set
    public void setLength ( double newVal){

        if (newVal < 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        this.length = newVal;
    }

    public void setWidth ( double newVal){
        if (newVal < 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = newVal;
    }

}

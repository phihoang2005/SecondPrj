/*
 *@ (#) TestRectangle.java     1.0  8/29/2024
 *Copyright (c) 2024 IUH  . All right reserved.
 */

package iuh.fit.se;

/*
 *@description:
 *@author:Nguyen Tran Phi Hoang
 *@date:    8/29/2024
 *version:  1.0
 */
public class TestRectangle {
    public static void main(String[] args) {
        iuh.fit.se.Rectangle r1=new iuh.fit.se.Rectangle();
        iuh.fit.se.Rectangle r2=new Rectangle(20.5,3.0);
        System.out.println("Length r1= "+r1.getLength());
        System.out.println("Width r1= "+r1.getWidth());
        System.out.println("Length r2= "+r2.getLength());
        System.out.println("Width r2= "+r2.getWidth());
        System.out.println("Area r1= "+r1.getArea());
        System.out.println("Area r2= "+r2.getArea());
        System.out.println("Perimeter r1= "+r1.getPerimeter());
        System.out.println("Perimeter r2= "+r2.getPerimeter());
    }
}

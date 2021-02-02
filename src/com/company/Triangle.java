package com.company;

import java.awt.*;
import java.util.Scanner;


class Triangle {
    //стороны
    double side1;
    double side2;
    double side3;

    boolean valid;

    Triangle(double side1, double side2, double side3) {
        //стороны
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        valid = side1 + side2 > side3
            && side2 + side3 > side1
            && side3 + side1 > side2;
    }

    void out() {
        System.out.print("Первая сторона:");
        System.out.println(side1);
        System.out.print("Вторая сторона:");
        System.out.println(side2);
        System.out.print("Третья сторона:");
        System.out.println(side3);

        System.out.println(valid);

    }

    void isValid() {
        if(this.valid) {
            System.out.println("Это треугольник");
        } else {
            System.out.println("Это не треугольник");
        }
    }

    void area() {
        if(this.valid) {
            double p = (side1 + side2 + side2)/2;
            double S = Math.sqrt(p * (p-side1) * (p - side2) * (p - side3));
            System.out.println("Площадь треуголника:");
            System.out.println(S);
        }
        else {
            System.out.println("Фигура не является треугольником!");
        }
    }
}

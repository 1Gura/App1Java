package ru.bstu.it31.gura.lab2;

import org.apache.logging.log4j.*;

import java.awt.*;
import java.util.Scanner;

class Triangle {
    static final Logger Logger = LogManager.getLogger(Triangle.class);
    //стороны
    int side1;
    int side2;
    int side3;

    boolean valid;

    /**Проверка существования треугольника и вычисление его площади.
     *
     * <p>
     *     Класс описывает свойства треугольника и методы для обработки этих свойств.
     *     Такие как: вычисление площади, проверка треугольника на свущетвование.
     * </p>
     * @param  side1 1 сторона треуголника
     * @param  side2 2 сторона треуголника
     * @param  side3 3 сторона треуголника
     */

    Triangle(int side1, int side2, int side3) {
        //стороны
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        valid = side1 + side2 > side3
            && side2 + side3 > side1
            && side3 + side1 > side2;
    }

    void out() {
        if(this.valid) {
            Logger.info("Это треугольник");
            Logger.info("Первая сторона:" + side1);
            Logger.info("Вторая сторона:" + side2);
            Logger.info("Третья сторона:" + side3);
        } else {
            Logger.info("Это не треугольник");
        }
    }

    void area() {
        if(this.valid) {
            int p = (side1 + side2 + side3)/2;
            Logger.debug("Полупериметр треугольника:" + p);
            double S = Math.sqrt(p * (p-side1) * (p - side2) * (p - side3));
            Logger.info("Площадь треуголника:" + S);
        }
        else {
            Logger.info("Площадь посчитать невозможно!");
        }
    }
}

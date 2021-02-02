package com.company;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static Triangle inputVertex() {
        double side1,side2,side3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите 1 сторону: ");
        side1 = sc.nextInt();
        System.out.print("Введите 2 сторону: ");
        side2 = sc.nextInt();
        System.out.print("Введите 3 сторону: ");
        side3 = sc.nextInt();

        Triangle triangle = new Triangle(side1,side2,side3);
        return triangle;
    }

    static void firstTask(){
        Triangle triangle = inputVertex();
        triangle.out();
        triangle.isValid();
        triangle.area();
    }

    static Date inputDate() {
        Date date = new Date();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = sc.nextInt();
        System.out.print("Введите месяц: ");
        int month = sc.nextInt();
        date.setYear(year);
        date.setMonth(month - 1);
        return date;
    }

    static void secondTask(){
        Date date =  inputDate();
        System.out.print("Введенный год:");
        System.out.println(date.getYear());
        System.out.print("Введенный месяц:");
        System.out.println(date.getMonth());
        int month = date.getMonth();
        int year = date.getYear();
        switch (month) {
            case 1 : {
                System.out.println("Январь : 31 день");
            } break;
            case 2 : {
                if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    System.out.println("Февраль : 29 день");
                } else {
                    System.out.println("Февраль : 28 день");
                }
            } break;
            case 3 : {
                System.out.println("Март : 31 день");
            } break;
            case 4 : {
                System.out.println("Апрель : 30 день");
            } break;
            case 5 : {
                System.out.println("Май : 31 день");
            } break;
            case 6 : {
                System.out.println("Июнь : 30 день");
            } break;
            case 7 : {
                System.out.println("Июль : 31 день");
            } break;
            case 8 : {
                System.out.println("Август : 31 день");
            } break;
            case 9 : {
                System.out.println("Сентябрь : 30 день");
            } break;
            case 10 : {
                System.out.println("Октябрь : 31 день");
            } break;
            case 11 : {
                System.out.println("Ноябрь : 30 день");
            } break;
            case 12 : {
                System.out.println("Декабрь : 31 день");
            } break;
            default:
                System.out.println("Все плохо...");
        }
    }

    static SportsMen inputSportsMen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите кол-во километров пробегаемых спортсменом за день:");
        int n  = sc.nextInt();
        System.out.print("Введите процент увеличения дневной нормы:");
        int m  = sc.nextInt();
        System.out.print("Введите кол-во дней:");
        int k  = sc.nextInt();

        SportsMen sportsMen = new SportsMen(n,m,k);
        return sportsMen;
    }

    static void thirdTask() {
        SportsMen sportsMen = inputSportsMen();
        sportsMen.getSum();
    }

    static  int[] arrayInitialization (int n) {
        Scanner sc = new Scanner(System.in);
        int nums[] = new int[n];
        for(int i = 0; i<nums.length; i++) {
            System.out.print("Введите " + i + " элемент: ");
            nums[i] = getInt();
        }
        return nums;
    }


    static void fourthTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размерность массива:");
        int n  = sc.nextInt();
        int nums[] = arrayInitialization(n);
        for(int i = 0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int getInt() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Введенно некоректное значение...");
            sc.next();
        }
        return sc.nextInt();
    }

    static void tasks(){
        System.out.print("Задача №1  - 1 \nЗадача №2  - 2 \nЗадача №3  - 3 \nЗадача №4  - 4 \nдля выхода нажмите 0 \n");
        boolean run = true;
        while(run) {
        System.out.print("Введите номер задания: ");
        int choice = getInt();
            switch (choice) {
                case 1: {
                    System.out.println("Первое задание.");
                    firstTask();
                } break;

                case 2: {
                    System.out.println("Второе задание.");
                    secondTask();
                } break;

                case 3: {
                    System.out.println("Третье задание.");
                    thirdTask();
                } break;
                case 4: {
                    System.out.println("Четвертое задание.");
                    fourthTask();
                } break;
                default: {
                    System.out.println("Введенно неверное значение!");
                } break;

                case 0: {
                    run = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        tasks();
    }
}

package com.company;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static Triangle inputVertex() {
        int side1,side2,side3;
        System.out.print("Введите 1 сторону: ");
        side1 = getNum();
        System.out.print("Введите 2 сторону: ");
        side2 = getNum();
        System.out.print("Введите 3 сторону: ");
        side3 = getNum();

        Triangle triangle = new Triangle(side1,side2,side3);
        return triangle;
    }

    public static int[] readFromFile(String path) {
        try {
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.println("3 4 5");
                printWriter.close();
            }
            Scanner scanner = new Scanner(file);
            String string = "";
            while (scanner.hasNextLine()) {
                string = scanner.nextLine();
            }
            String[] numbersString = string.split(" ");
            int numbers[] = new int[numbersString.length];
            for (int i = 0; i < numbersString.length; i++) {
                numbers[i] = Integer.parseInt(numbersString[i]);
            }
            return numbers;

        } catch (IOException e) {
            return new int[0];
        }
    }


    static int inputKey() {
        System.out.println("Введите 1, если хотите считывать из консоли, если хотите считывать из файла 2... ");
        int choice = getNum();
        return choice;
    }

    static void firstTask(){
        int choice = inputKey();
        switch(choice) {
            case 1 : {
                Triangle triangle = inputVertex();
                triangle.out();
                triangle.area();
            } break;
            case 2 : {
                int [] params = readFromFile("../notes1.txt");
                Triangle triangle = new Triangle(params[0],params[1],params[2]);
                triangle.out();
                triangle.area();
            } break;
        }
    }

    static Date inputDate() {
        Date date = new Date();
        System.out.print("Введите год: ");
        int year = getNum();
        System.out.print("Введите месяц: ");
        int month = getNum();
        date.setYear(year);
        date.setMonth(month);
        return date;
    }

    

    static void numberDayOfMonth(int month, int year) {

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
                System.out.println("Введите номер месяца от 1 до 12");
        }
    }

    static void secondTask(){
        int choice = inputKey();
        switch(choice) {
            case 1 : {
                Date date =  inputDate();
                int month = date.getMonth();
                int year = date.getYear();
                numberDayOfMonth(month, year);
            } break;
            case 2 : {
                int [] params = readFromFile("../notes2.txt");
                numberDayOfMonth(params[0], params[1]);
            } break;
        }
    }



    static SportsMen inputSportsMen() {
        System.out.print("Введите кол-во километров пробегаемых спортсменом за день:");
        int n  = getNum();
        System.out.print("Введите процент увеличения дневной нормы:");
        int m  = getNum();
        System.out.print("Введите кол-во дней:");
        int k  = getNum();

        SportsMen sportsMen = new SportsMen(n,m,k);
        return sportsMen;
    }

    static void thirdTask() {
        int choice = inputKey();
        switch(choice) {
            case 1 : {
                SportsMen sportsMen = inputSportsMen();
                sportsMen.getSum();
            } break;
            case 2 : {
                int [] params = readFromFile("../notes3.txt");
                SportsMen sportsMen = new SportsMen(params[0], params[1], params[2]);
                sportsMen.getSum();
            } break;
        }
    }

    static  int[] arrayInitialization (int n) {
        if(n > 0) {
            int nums[] = new int[n];
            for(int i = 0; i<nums.length; i++) {
                System.out.print("Введите " + i + " элемент: ");
                nums[i] = getNum();
            }
            return nums;
        } else {
            System.out.println("Размерность массива не может быть отрицательной!");
            return new int[0];
        }
    }


    static void searchNumber(int[] nums, boolean flag) {
        if(nums.length > 0) {
            for(int i = 0; i<nums.length - 1; i++) {
                if(nums[i] < 0 && nums[i+1] > 0) {
                    System.out.println("Первым встречается отрицательное");
                    flag = true;
                    break;
                } else if(nums[i] > 0 && nums[i+1] < 0) {
                    System.out.println("Первым встречается положительное");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Массив состоит только из положительны или отрицательных чисел.");
            }
        }
    }

    static void fourthTask() {
        int choice = inputKey();
        boolean flag = false;
        switch(choice) {
            case 1 : {
                System.out.print("Введите размерность массива: ");
                int n  = getNum();
                int nums[] = arrayInitialization(n);
                searchNumber(nums, flag);
            } break;
            case 2 : {
                int [] params = readFromFile("../notes4.txt");
                searchNumber(params, flag);
            } break;
        }
    }

    public static int getNum() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Введенно некоректное значение!");
            System.out.print("Введите значение повторно: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static void tasks(){
        System.out.print("Задача №1  - 1 \nЗадача №2  - 2 \nЗадача №3  - 3 \nЗадача №4  - 4 \nдля выхода нажмите 0 \n");
        boolean run = true;
        while(run) {
            System.out.print("Введите номер задания: ");
            int choice = getNum();
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

package ru.bstu.it31.gura.lab2;

import org.apache.logging.log4j.*;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

/** Выполняет решение следующих задач:.
 *
 *<p>
 *     1) Даны три положительных числа а, Ь, с. Проверить, будут ли
 *     они сторонами треугольника. Если да, то вычислить площадь
 *     этого треугольника.
 * </p>
 * <p>
 *     2) Составить программу, которая по заданным году и номеру
 *     месяца т определяет количество дней в этом месяце.
 * </p>
 * <p>
 *     3) Начав тренировки, спортсмен в первый день пробежал n км.
 *     Каждый день он увеличивал дневную норму на m% нормы
 *     предыдущего дня. Какой суммарный путь пробежит спортсмен
 *     за k дней?
 * </p>
 * <p>
 *     Дана последовательность целых чисел а1,а2,..., аn. Выяснить,
 *     какое число встречается раньше — положительное или
 *     отрицательное.
 * </p>
 * @version 1.0
 * @author Гура Илья
 */

public class App {

    static final Logger Logger = LogManager.getLogger(App.class);

    // метод, который передает набор параметров в конструктор класса Triangle
    public static Triangle inputVertex() {
        int side1,side2,side3;
        System.out.print("Введите 1 сторону: ");
        side1 = getNum();
        Logger.info("Введенно число:" + side1);
        System.out.print("Введите 2 сторону: ");
        side2 = getNum();
        Logger.info("Введенно число:" + side2);
        System.out.print("Введите 3 сторону: ");
        side3 = getNum();
        Logger.info("Введенно число:" + side3);

        Triangle triangle = new Triangle(side1,side2,side3);
        return triangle;
    }

    public static int[] readFromFile(String path) { // метод предназначенный для считывания данных из файла
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

    // метод предназначенный для считывания данных из файла или с консоли
    static int inputKey() {
        System.out.println("Введите 1, если хотите считывать из консоли, если хотите считывать из файла 2... ");
        int choice = getNum();
        if(choice == 1) {
            Logger.info("Был выбран ввод с клавиатуры");
        } else if(choice == 2) {
            Logger.info("Был выбран ввод из файла");
        }
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
    // метод предназначенный для ввода даты
    static Date inputDate() {
        Date date = new Date();
        System.out.print("Введите год: ");
        int year = getNum();
        Logger.info("Был введен год" + year);
        System.out.print("Введите месяц: ");
        int month = getNum();
        Logger.info("Был введен месяц" + month);
        date.setYear(year);
        date.setMonth(month);
        return date;
    }


    // метод предназначенный для вычисления кол-ва дней в месяце
    static void numberDayOfMonth(int month, int year) {
    try {
        if(year < 0) {
            String error = "Год не может быть меньше нуля!";
            Logger.error(error);
            throw new Exception(error);
        }
        switch (month) {
            case 1 : {
                Logger.info("Январь : 31 день");
            } break;
            case 2 : {
                if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    Logger.info("Февраль : 29 день");
                } else {
                    Logger.info("Февраль : 28 день");
                }
            } break;
            case 3 : {
                Logger.info("Март : 31 день");
            } break;
            case 4 : {
                Logger.info("Апрель : 30 день");
            } break;
            case 5 : {
                Logger.info("Май : 31 день");
            } break;
            case 6 : {
                Logger.info("Июнь : 30 день");
            } break;
            case 7 : {
                Logger.info("Июль : 31 день");
            } break;
            case 8 : {
                Logger.info("Август : 31 день");
            } break;
            case 9 : {
                Logger.info("Сентябрь : 30 день");
            } break;
            case 10 : {
                Logger.info("Октябрь : 31 день");
            } break;
            case 11 : {
                Logger.info("Ноябрь : 30 день");
            } break;
            case 12 : {
                Logger.info("Декабрь : 31 день");
            } break;
            default:
                Logger.warn("Введенный месяц не входит в диапазон от 1 до 12");
        }
    }catch (Exception ex) {
        Logger.error(ex);
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


    // метод, который передает набор параметров в конструктор класса SportsMen
    static SportsMen inputSportsMen() {
        System.out.print("Введите кол-во километров пробегаемых спортсменом за день:");
        int n  = getNum();
        Logger.info("Ввели кол-во километров" + n);
        System.out.print("Введите процент увеличения дневной нормы:");
        int m  = getNum();
        Logger.info("Ввели процент дневной нормы" + m);
        System.out.print("Введите кол-во дней:");
        int k  = getNum();
        Logger.info("Ввели кол-во дней" + k);

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

    // метод для инициализации массива
    static  int[] arrayInitialization (int n) {
        if(n > 0) {
            int nums[] = new int[n];
            for(int i = 0; i<nums.length; i++) {
                System.out.print("Введите " + i + " элемент: ");
                nums[i] = getNum();
                Logger.info("Ввели" + i + "элемент = " + nums[i]);
            }
            return nums;
        } else {
            Logger.warn("Размерность массива не может быть отрицательной!");
            return new int[0];
        }
    }

    // метод для поиска первого положительного или отрицательного числа
    static void searchNumber(int[] nums) {
        if(nums.length > 0) {
            for(int i = 0; i<nums.length - 1; i++) {
                if(nums[i] < 0) {
                    System.out.println("Первым встречается отрицательное");
                    break;
                } else if(nums[i]  > 0) {
                    System.out.println("Первым встречается положительное");
                    break;
                }
            }
        }
    }

    static void fourthTask() {
        int choice = inputKey();
        switch(choice) {
            case 1 : {
                System.out.print("Введите размерность массива: ");
                int n  = getNum();
                Logger.info("Ввели размерность массива:" + n);
                int nums[] = arrayInitialization(n);
                searchNumber(nums);
            } break;
            case 2 : {
                int [] params = readFromFile("../notes4.txt");
                searchNumber(params);
            } break;
        }
    }
    // метод для ввода числовых значений
    public static int getNum() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Введенно некоректное значение!");
            System.out.print("Введите значение повторно: ");
            sc.next();
        }
        return sc.nextInt();
    }


    /** Функция выбора задачи
     *
     * <p>
     *     Осуществляется выбор номера задачи
     * </p>
     */
    static void tasks(){
        System.out.print("Задача №1  - 1 \nЗадача №2  - 2 \nЗадача №3  - 3 \nЗадача №4  - 4 \nдля выхода нажмите 0 \n");
        boolean run = true; // логическое значение свидетельствующее о том, что программы исполняется, как только будет принято значение false, программа завершится
        while(run) {
            System.out.print("Введите номер задания: ");
            int choice = getNum();
            switch (choice) {
                case 1: {
                    Logger.info("Было выбрано первое задание");
                    firstTask();
                } break;

                case 2: {
                    Logger.info("Было выбрано второе задание");
                    secondTask();
                } break;

                case 3: {
                    Logger.info("Было выбрано третье задание");
                    thirdTask();
                } break;
                case 4: {
                    Logger.info("Было выбрано четвёртое задание");
                    fourthTask();
                } break;
                default: {
                    Logger.info("Было выбрано четвёртое задание");
                } break;

                case 0: {
                    Logger.info("Программа была завершена нажатем на кнопку выхода");
                    run = false;
                }
            }
        }
    }

    /** Главная функция.
     *
     * <p>
     *     Внутри функции main осуществляется запуск функции tasks
     * </p>
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        tasks();
    }
}

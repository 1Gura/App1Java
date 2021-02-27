package ru.bstu.it31.gura.lab2;
import org.apache.logging.log4j.*;
public class SportsMen {
    static final Logger Logger = LogManager.getLogger(SportsMen.class);
    /**Класс спортсмен.
     *
     * <p>
     *     Класс описывает свойства спортсмена и методы для обработки этих свойств.
     *     Такие как: Подсчёт суммарной дистанции.
     * </p>
     */

    private int n; //километры
    private int m; //проценты дневной нормы
    private int k; //кол-во дней

    public SportsMen(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

    void getSum() {
        double temp = this.n;
        double sum = 0;
        for (int i = 1; i < this.k; i++) {
            temp = temp + temp * this.m/100;
            sum += temp;
        }
        sum = this.n + sum;
        Logger.info("Суммарный путь (цикл for): " + sum);

        temp = this.n;
        sum = 0;
        int count = this.k;
        while (count != 1) {
            temp = temp + temp * this.m/100;
            sum += temp;
            count--;
        }
        sum = this.n + sum;
        Logger.info("Суммарный путь (цикл while): " + sum);
    }

}

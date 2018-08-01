package model.enums;

import model.interfaces.GasolineCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * enum with gasoline cars.
 */
public enum GasolinePark implements GasolineCar {

    BMW_X5(235, 9, 60000),
    FERRARY_458(325, 14, 200000),
    FERRART_CALIFORNIA(312, 11, 257600),
    DAEWOO_LANOS(172, 8, 4000),
    AUDI_TT(250, 7, 52100);

    private static int parkPrice;
    private int speed;
    private int consumption;
    private int price;

    /**
     *
     * @param speed
     * @param consumption
     * @param price
     */
    GasolinePark(int speed, int consumption, int price) {
        this.speed = speed;
        this.consumption = consumption;
        this.price = price;
    }

    /**
     *
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *
     * @return consumption
     */
    public int getConsumption() {
        return consumption;
    }

    /**
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @return parkPrice
     */
    public static int getParkPrice() {
        parkPrice = 0;
        List<GasolineCar> list = new ArrayList(Arrays.asList(GasolinePark.values()));
        for(GasolineCar temp : list) {
            parkPrice += temp.getPrice();
        }

        return parkPrice;
    }

    /**
     * Comparator
     * Compares consumption cars
     */
    public static Comparator<GasolineCar> gasolineComparator = new Comparator<GasolineCar>() {
        public int compare(GasolineCar d1, GasolineCar d2) {
            return d2.getConsumption() - d1.getConsumption();
        }
    };

}


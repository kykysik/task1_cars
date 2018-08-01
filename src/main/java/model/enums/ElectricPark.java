package model.enums;


import model.interfaces.ElectricCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum ElectricPark implements ElectricCar {

    TESLA_MODEL_S(210, 420, 65000),
    TESLA_MODEL_X(250, 400, 71000),
    TESLA_MODEL_3(225, 500, 50000),
    AUDI_E_TRON_SPORTBACK(210, 450, 94000),
    BMW_I3(150, 160, 60250);

    private static int parkPrice;
    private int speed;
    private int consumption;
    private int price;

    ElectricPark(int speed, int consumption, int price) {
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
        List<ElectricPark> list = new ArrayList(Arrays.asList(ElectricPark.values()));
        for(ElectricPark temp : list) {
            parkPrice += temp.getPrice();
        }

        return parkPrice;
    }

}

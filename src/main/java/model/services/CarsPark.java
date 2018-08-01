package model.services;

import model.enums.ElectricPark;
import model.enums.GasolinePark;

import java.util.ArrayList;
import java.util.List;

/**
 * Park of Cars
 */
public class CarsPark {

    private int min;
    private int max;
    private int price = GasolinePark.getParkPrice() + ElectricPark.getParkPrice();
    private  List<ElectricPark> electricList = new ArrayList();
    private  List<GasolinePark> gasolineList = new ArrayList();


    public CarsPark(int min, int max) {
        this.max = max;
        this.min = min;
        carsWithSuituableSpeed();
    }

    /**
     *
     * @return price all cars
     */
    public int getPrice() {
        return price;
    }

    public  List getGasolineList() {
        return gasolineList;
    }

    public  List getElectricList() {
        return electricList;
    }

    /**
     * Finds cars with a suitable speed
     */
    public void carsWithSuituableSpeed() {
        for(GasolinePark gasoline : GasolinePark.values()) {
            if((gasoline.getSpeed() >= min) && (gasoline.getSpeed() <= max )) {
                gasolineList.add(gasoline);

            }
        }

        for(ElectricPark electric : ElectricPark.values()) {
            if((electric.getSpeed() >= min) && (electric.getSpeed() <= max )) {
                electricList.add(electric);
            }
        }
    }

}

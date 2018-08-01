package model.services;

import model.enums.ElectricPark;
import model.enums.GasolinePark;
import model.interfaces.ElectricCar;
import model.interfaces.GasolineCar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Compare class
 */
public class Compare {

    /**
     *
     * @return comparesList of Gasoline cars
     */
    public List gasolineCompare() {
        List<GasolinePark> comparesList = Arrays.asList(GasolinePark.values());
        Collections.sort(comparesList, gasolineComparator);
        return comparesList;
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

    /**
     *
     * @return comparesList of Electric cars
     */
    public List electricCompare() {
        List<ElectricPark> comparesList = Arrays.asList(ElectricPark.values());
        Collections.sort(comparesList, electricComparator);
        return comparesList;
    }

    /**
     * Comparator.
     * Compares consumption cars
     */
    public static Comparator<ElectricCar> electricComparator = new Comparator<ElectricCar>() {
        public int compare(ElectricCar d1, ElectricCar d2) {
            return d2.getConsumption() - d1.getConsumption();
        }
    };
}

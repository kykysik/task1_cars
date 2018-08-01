package model.services;

import model.enums.ElectricPark;
import model.enums.GasolinePark;

import java.util.Arrays;
import java.util.Collections;
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
        Collections.sort(comparesList, GasolinePark.gasolineComparator);
        return comparesList;
    }

    /**
     *
     * @return comparesList of Electric cars
     */
    public List electricCompare() {
        List<ElectricPark> comparesList = Arrays.asList(ElectricPark.values());
        Collections.sort(comparesList, ElectricPark.electricComparator);
        return comparesList;
    }
}

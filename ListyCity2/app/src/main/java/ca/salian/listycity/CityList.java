package ca.salian.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities); // create a copy to sort
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a given city exists in the list
     * @param city
     * The city to check for
     * @return
     * True if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list
     * @param city
     * The city to delete
     * @throws IllegalArgumentException
     * If the city does not exist in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found: " + city.getCityName());
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list
     * @return
     * Number of cities currently stored
     */
    public int countCities() {
        return cities.size();
    }
}

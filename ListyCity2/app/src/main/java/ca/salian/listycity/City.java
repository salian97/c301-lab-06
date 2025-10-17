package ca.salian.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructor for a City object
     * @param city
     * The name of the city
     * @param province
     * The name of the province the city belongs to
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Get the name of the city
     * @return
     * The city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Get the name of the province
     * @return
     * The province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city with another city by name
     * @param o
     * The other city to compare to
     * @return
     * 0 if the names are equal, negative if this city comes first, positive if it comes after
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Checks whether two City objects are equal
     * @param o
     * The object to compare
     * @return
     * True if the city and province names are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    /**
     * Generates a hash code for the city
     * @return
     * Hash code based on city and province
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}

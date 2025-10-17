package ca.salian.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the functionality of the CityList class.
 */
class CityListTest {

    /**
     * Creates a mock CityList containing one city for testing
     * @return
     * A CityList with one city
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City object for testing
     * @return
     * A City object (Edmonton, Alberta)
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Tests adding a city to the CityList
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Tests that adding a duplicate city throws an exception
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Tests retrieving cities in sorted order
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Tests whether hasCity correctly identifies a city in the list
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        assertFalse(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    /**
     * Tests deleting a city from the list
     */
    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = mockCity();
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Tests that deleting a non-existent city throws an exception
     */
    @Test
    void testDeleteCityException() {
        CityList cityList = mockCityList();
        City nonExistentCity = new City("Regina", "Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(nonExistentCity));
    }

    /**
     * Tests counting the number of cities in the list
     */
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
    }
}

package Service;

import Model.VehicleJson.Vehicle;

import java.util.ArrayList;
import java.util.Collection;

public interface IRentalCars {
    ArrayList<Vehicle> getCars();
    ArrayList<Vehicle> getCarsWithSpec();
    Collection<Vehicle> getCarsByRaiting();
    ArrayList<Vehicle> getCarsByScore();
    void displayCars();
    void displaySpec();
    void displayByRaiting();
    void displayByScore();
}
package Service;

import Data.IRepository;
import Model.VehicleJson.Vehicle;
import Service.CarScore.ICarScore;
import Service.CarSpec.ICarSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RentalCars implements IRentalCars {

    final private IRepository repository;
    final private ICarSpec carSpec;
    final private ICarScore carScore;

    @Autowired
    public RentalCars(IRepository repository, ICarSpec carSpec, ICarScore carScore) {
        this.repository = repository;
        this.carSpec = carSpec;
        this.carScore = carScore;
    }

    @Override
    public void displayCars() {
        ArrayList<Vehicle> vehicles = this.repository.getVehicleList();
        if (vehicles.isEmpty()) {
            return;
        }

        vehicles.sort(Comparator.comparing(v -> v.price));

        int i = 0;
        for (Vehicle vehicle : vehicles) {
            System.out.println(Integer.toString(++i) + ". " + vehicle.toString());
        }
    }

    @Override
    public void displaySpec() {
        int i = 0;
        for (Vehicle vehicle : this.repository.getVehicleList()) {

            // Load the sipp
            vehicle.setSipp(carSpec.getSipp(vehicle.sipp));

            System.out.println(Integer.toString(++i) + ". " + vehicle.getSpec());
        }
    }

    @Override
    public void displayByRaiting() {
        ArrayList<Vehicle> vehicles = this.repository.getVehicleList();
        if (vehicles.isEmpty()) {
            return;
        }

        Collections.sort(vehicles, Comparator.comparing(Vehicle::getRaiting).reversed());
        HashMap<String, Vehicle> rankingVehicles = new HashMap<>();

        for (Vehicle vehicle : vehicles) {
            // Get car type
            String carType = carSpec.getSipp(vehicle.sipp).getCarType();

            // Check rankedlist for record
            if (!rankingVehicles.containsKey(carType)) {
                // Add vehicle for this car type
                rankingVehicles.put(carType, vehicle);
            }
        }

        // Display results
        int i = 0;
        for (Vehicle vehicle : rankingVehicles.values()) {
            String carType = carSpec.getSipp(vehicle.sipp).getCarType();
            String out = Integer.toString(++i) + ". " + vehicle.name + " - " + carType + " - " + vehicle.supplier + " - " + vehicle.rating;
            System.out.println(out);
        }
    }

    @Override
    public void displayByScore() {
        ArrayList<Vehicle> vehicles = this.repository.getVehicleList();
        if (vehicles.isEmpty()) {
            return;
        }

        // Get vehicle score
        for (Vehicle vehicle : vehicles) {
            vehicle.set_score(carScore.getScore(vehicle.sipp));
        }

        // Sort
        Collections.sort(vehicles, Comparator.comparing(Vehicle::getSum).reversed());

        // Display results
        int i = 0;
        for (Vehicle vehicle : vehicles) {
            String out = Integer.toString(++i) + ". " +
                    vehicle.name + " - " +
                    Double.toString(vehicle.getScore()) + " - " +
                    vehicle.rating + " - " +
                    Double.toString(vehicle.getSum());

            System.out.println(out);
        }
    }
}

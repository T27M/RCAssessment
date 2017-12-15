package Service;

import Data.IRepository;
import Model.VehicleJson.Sipp;
import Model.VehicleJson.Vehicle;
import Service.CarSpec.ICarSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RentalCars implements IRentalCars {

    final private IRepository repository;
    final private ICarSpec carSpec;

    private final int manualTransmission = 1;
    private final int autoTransmission = 5;
    private final int hasAc = 2;

    @Autowired
    public RentalCars(IRepository repository, ICarSpec carSpec) {
        this.repository = repository;
        this.carSpec = carSpec;
    }

    @Override
    public void displayCars() {
        ArrayList<Vehicle> vehicles = this.repository.getVehicleList();
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
            vehicle.set_sipp(carSpec.getSipp(vehicle.sipp));

            System.out.println(Integer.toString(++i) + ". " + vehicle.getSpec());
        }
    }

    @Override
    public void displayByRaiting() {
//        ArrayList<Vehicle> vehicles = this.repository.getVehicleList();
//        HashMap<String, Vehicle> rankingVehicles = new HashMap<>();
//
//        if (vehicles.isEmpty()) {
//            return;
//        }
//
//        for (Vehicle vehicle : vehicles) {
//            // Get car type
//            String carType = carSpec.getCarType(vehicle.sipp);
//
//            System.out.println(carType);
//
//            // Check rankedlist for record
//            if (!rankingVehicles.containsKey(carType)) {
//                // Add vehicle for this car type
//                rankingVehicles.put(carType, vehicle);
//            } else {
//
//                // Compare current with stored
//                Vehicle current = rankingVehicles.get(carType);
//
//                if (current.rating < vehicle.rating) {
//                    // Replace if ranking lower
//                    rankingVehicles.replace(carType, vehicle);
//                }
//            }
//        }
//
//        int i = 0;
//        for (Vehicle vehicle : rankingVehicles.values()) {
//            String carType = carSpec.getCarType(vehicle.sipp);
//            String out = Integer.toString(++i) + ". " + vehicle.name + " - " + carType + " - " + vehicle.supplier + " - " + vehicle.rating;
//            //System.out.println(out);
//        }
    }

    @Override
    public void displayByScore() {

        // Tree map is unique - won't work
//        TreeMap<Double, String> sortedMap = new TreeMap<>();
//
//
//        for (Vehicle vehicle : this.getData()) {
//
//            Double score = 0.0;
//            char[] _sipp = vehicle.sipp.toCharArray();
//
//            if (_sipp[2] == 'M') {
//                score += manualTransmission;
//            } else {
//                score += autoTransmission;
//            }
//
//            if (_sipp[3] == 'R') {
//                score += hasAc;
//            }
//
//            Double sum = score + vehicle.rating;
//
//            String out = vehicle.name + " - " +
//                    Double.toString(score) + " - " +
//                    vehicle.rating + " - " +
//                    Double.toString(sum);
//
//            //sortedMap.put(sum, out);
//
//            System.out.println(out);
//        }
//
//        int i = 0;
//        for (Map.Entry<Double, String> entry : sortedMap.entrySet())
//        {
//            System.out.println(Integer.toString(++i) + ". " + entry.getValue());
//        }
    }
}

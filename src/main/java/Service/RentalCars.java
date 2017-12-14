package Service;

import JsonParser.IJsonParser;
import JsonParser.Sipp;
import JsonParser.Vehicle;
import Service.CarSpec.ICarSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class RentalCars implements IRentalCars {

    final private IJsonParser parser;
    final private ICarSpec carSpec;

    private final int manualTransmission = 1;
    private final int autoTransmission = 5;
    private final int hasAc = 2;

    @Autowired
    public RentalCars(IJsonParser parser, ICarSpec carSpec) {
        this.parser = parser;
        this.carSpec = carSpec;
    }

    private ArrayList<Vehicle> getData() {
        try {
            ArrayList<Vehicle> vehicle = parser.getData().searchData.vehicles;

            for (Vehicle v : vehicle) {
                v.Sipp = carSpec.createSipp(v.sipp);
            }

            return vehicle;
        } catch (IOException e) {
            System.out.println("Could not fetch data");
            return new ArrayList<>();
        }
    }

    @Override
    public void displayCars() {
        ArrayList<Vehicle> vehicles = this.getData();
        vehicles.sort(Comparator.comparing(v -> v.price));

        int i = 0;
        for (Vehicle vehicle : vehicles) {
            System.out.println(Integer.toString(++i) + ". " + vehicle.toString());
        }
    }

    @Override
    public void displaySpec() {
        int i = 0;
        for (Vehicle vehicle : this.getData()) {
            System.out.println(Integer.toString(++i) + ". " + vehicle.name + " - " + vehicle.sipp + " - " + carSpec.getSpec(vehicle.sipp));
        }
    }

    @Override
    public void displayByRaiting() {

        ArrayList<Vehicle> vehicles = this.getData();
        HashMap<String, Vehicle> rankingVehicles = new HashMap<>();

        if (vehicles.isEmpty()) {
            return;
        }

        for (Vehicle vehicle : vehicles) {
            // Get car type
            String carType = carSpec.getCarType(vehicle.sipp);

            System.out.println(carType);

            // Check rankedlist for record
            if (!rankingVehicles.containsKey(carType)) {
                // Add vehicle for this car type
                rankingVehicles.put(carType, vehicle);
            } else {

                // Compare current with stored
                Vehicle current = rankingVehicles.get(carType);

                if (current.rating < vehicle.rating) {
                    // Replace if ranking lower
                    rankingVehicles.replace(carType, vehicle);
                }
            }
        }

        int i = 0;
        for (Vehicle vehicle : rankingVehicles.values()) {
            String carType = carSpec.getCarType(vehicle.sipp);
            String out = Integer.toString(++i) + ". " + vehicle.name + " - " + carType + " - " + vehicle.supplier + " - " + vehicle.rating;
            //System.out.println(out);
        }
    }

    @Override
    public void displayByScore() {

        // Tree map is unique - won't work
        TreeMap<Double, String> sortedMap = new TreeMap<>();


        for (Vehicle vehicle : this.getData()) {

            Double score = 0.0;
            char[] _sipp = vehicle.sipp.toCharArray();

            if (_sipp[2] == 'M') {
                score += manualTransmission;
            } else {
                score += autoTransmission;
            }

            if (_sipp[3] == 'R') {
                score += hasAc;
            }

            Double sum = score + vehicle.rating;

            String out = vehicle.name + " - " +
                    Double.toString(score) + " - " +
                    vehicle.rating + " - " +
                    Double.toString(sum);

            //sortedMap.put(sum, out);

            System.out.println(out);
        }

        int i = 0;
        for (Map.Entry<Double, String> entry : sortedMap.entrySet())
        {
            System.out.println(Integer.toString(++i) + ". " + entry.getValue());
        }
    }
}

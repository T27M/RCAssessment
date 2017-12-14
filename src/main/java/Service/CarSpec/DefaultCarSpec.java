package Service.CarSpec;

import JsonParser.Sipp;

import java.util.ArrayList;
import java.util.HashMap;

public class DefaultCarSpec implements ICarSpec {

    private HashMap<Character, String> carType = new HashMap<>();
    private HashMap<Character, String> doorOrCarType = new HashMap<>();
    private HashMap<Character, String> transmission = new HashMap<>();
    private HashMap<Character, String> fuelAirCon = new HashMap<>();

    private final ArrayList<Character> doorLetters = new ArrayList<>();

    public DefaultCarSpec() {
        registerCarType();
        registerDoorAndCarType();
        registerTransmission();
        registerFuelAndAirCon();
    }

    // 1st Letter Car Type
    private void registerCarType() {
        carType.put('M', "Mini");
        carType.put('E', "Economy");
        carType.put('C', "Compact");
        carType.put('I', "Intermediate");

        carType.put('S', "Standard");
        carType.put('F', "Full size");
        carType.put('P', "Premium");
        carType.put('L', "Luxury");

        carType.put('X', "Special");
    }

    //2nd Letter doors/car type
    private void registerDoorAndCarType() {
        doorLetters.add('B');
        doorLetters.add('C');
        doorLetters.add('D');

        doorOrCarType.put('B', "2 doors");
        doorOrCarType.put('C', "4 doors");
        doorOrCarType.put('D', "5 doors");

        doorOrCarType.put('W', "Estate");

        doorOrCarType.put('T', "Convertible");
        doorOrCarType.put('F', "SUV");
        doorOrCarType.put('P', "Pick up");
        doorOrCarType.put('V', "Passenger Van");
    }

    private void registerTransmission() {
        transmission.put('M', "Manual");
        transmission.put('A', "Automatic");
    }

    private void registerFuelAndAirCon() {
        fuelAirCon.put('N', "Petrol/no AC");
        fuelAirCon.put('R', "Petrol/AC");
    }

    @Override
    public String getSpec(String sipp) {
        char[] _sipp = sipp.toCharArray();

        String carType = this.getCarType(sipp);

        return carType + " - " + transmission.get(_sipp[2]) + " - " + fuelAirCon.get(_sipp[3]);
    }

    @Override
    public Sipp createSipp(String sipp) {

        char[] sippChar = sipp.toCharArray();

        Sipp _sipp = new Sipp();

        // Door letter rules
        if (doorLetters.contains(sippChar[1])) {
            _sipp.carType = carType.get(sippChar[0]);
            _sipp.carTypeDoors = doorOrCarType.get(sippChar[1]);
        } else if (sippChar[1] == 'X') {
            // Special car rules
            _sipp.setCombined();
            _sipp.carType = carType.get(sippChar[0]);
            _sipp.carTypeDoors = carType.get(sippChar[1]);
        } else {
            _sipp.setCombined();
            _sipp.carType = carType.get(sippChar[0]);
            _sipp.carTypeDoors = doorOrCarType.get(sippChar[1]);
        }

        _sipp.transmission = transmission.get(sippChar[2]);
        _sipp.fuelAc = fuelAirCon.get(sippChar[3]);

        return _sipp;
    }

    @Override
    public String getCarType1(String sipp) {

        String _carType = "";

        char[] _sipp = sipp.toCharArray();

        // Special rules for door letters
        if (doorLetters.contains(_sipp[1])) {
            _carType += carType.get(_sipp[0]);
        } else if (_sipp[1] == 'X') {
            // Special car type
            _carType += carType.get(_sipp[0]) + " " + carType.get(_sipp[1]);
        } else {
            _carType += carType.get(_sipp[0]) + " " + doorOrCarType.get(_sipp[1]);
        }

        return _carType;
    }
}
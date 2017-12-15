package Service.CarSpec;

import Data.IRepository;
import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.Sipp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CarSpec implements ICarSpec {

    final private IRepository repository;

    private enum LetterType {
        CarType,
        DoorCarType,
        Transmission,
        FuelAc
    }

    @Autowired
    public CarSpec(IRepository repository) {
        this.repository = repository;
    }

    private String getLetterValue(char letter, LetterType type) {
        VehicleSpec spec = repository.getVehicleSpec();

        String value = "";

        switch (type){
            case CarType:
                value = spec.carType.get(Character.toString(letter));
                break;
            case DoorCarType:
                value = spec.doorCarType.get(Character.toString(letter));
                break;
            case Transmission:
                value = spec.transmission.get(Character.toString(letter));
                break;
            case FuelAc:
                value = spec.fuelAc.get(Character.toString(letter));
                break;
        }

        return  value;
    }

    // Cache this?
    private ArrayList<String> doorLetters() {
        return repository.getVehicleSpec().doorLetters;
    }

    // Cache this?
    private ArrayList<String> specialLetters() {
        return repository.getVehicleSpec().specialLetters;
    }

    @Override
    public Sipp getSipp(String sipp) {

        String carType = "";
        String carTypeDoors = "";
        String transmission = "";
        String fuelAc = "";
        boolean combined = false;

        char[] sippChar = sipp.toCharArray();

        if (doorLetters().contains(Character.toString(sippChar[1]))) {
            // Door letter rules
            carType = getLetterValue(sippChar[0], LetterType.CarType);
            carTypeDoors = getLetterValue(sippChar[1], LetterType.DoorCarType);
        } else if (specialLetters().contains(Character.toString(sippChar[1]))) {
            // Special car rules
            combined = true;
            carType = getLetterValue(sippChar[0], LetterType.CarType);
            carTypeDoors = getLetterValue(sippChar[1], LetterType.CarType);
        } else {
            // Combined rules
            combined = true;
            carType = getLetterValue(sippChar[0], LetterType.CarType);
            carTypeDoors = getLetterValue(sippChar[1], LetterType.DoorCarType);
        }

        transmission = getLetterValue(sippChar[2], LetterType.Transmission);
        fuelAc = getLetterValue(sippChar[3], LetterType.FuelAc);

        return new Sipp(combined, sipp, carType,carTypeDoors, transmission,fuelAc);
    }
}
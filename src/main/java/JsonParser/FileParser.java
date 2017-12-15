package JsonParser;

import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.VehicleSearch;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileParser implements IJsonParser {

    private final String vehicleJson = "vehicles.json";
    private final String specJson = "spec.json";

    @Override
    public VehicleSearch getVehicleSearch() {
        try {
            Gson gson = new Gson();
            String jsonFile = FileParser.class.getClassLoader().getResource(vehicleJson).getFile();
            return gson.fromJson(new FileReader(jsonFile), VehicleSearch.class);
        } catch (FileNotFoundException e) {
            // Log
            System.out.println("Could not load data file: " + vehicleJson);
            return new VehicleSearch();
        }
    }

    @Override
    public VehicleSpec getVehicleSpec() {
        try {
            Gson gson = new Gson();
            String jsonFile = FileParser.class.getClassLoader().getResource(specJson).getFile();
            return gson.fromJson(new FileReader(jsonFile), VehicleSpec.class);
        } catch (FileNotFoundException e) {
            // Log
            System.out.println("Could not load data file: " + specJson);
            return new VehicleSpec();
        }
    }
}
package Model.SpecJson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * JSON Root Node
 */
public class VehicleSpec {
    @SerializedName("car_type")
    public HashMap<String, String> carType = new HashMap<>();
    @SerializedName("door_car_type")
    public HashMap<String, String> doorCarType = new HashMap<>();
    @SerializedName("transmission")
    public HashMap<String, String> transmission = new HashMap<>();
    @SerializedName("fuel_ac")
    public HashMap<String, String> fuelAc= new HashMap<>();
    @SerializedName("door_letters")
    public ArrayList<String> doorLetters = new ArrayList<>();
    @SerializedName("special_letters")
    public ArrayList<String> specialLetters = new ArrayList<>();
}
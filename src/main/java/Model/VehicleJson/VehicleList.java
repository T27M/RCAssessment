package Model.VehicleJson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VehicleList {
    @SerializedName("VehicleList")
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
}

package JsonParser;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchData {
    @SerializedName("VehicleList")
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
}

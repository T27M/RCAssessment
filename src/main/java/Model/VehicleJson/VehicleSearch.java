package Model.VehicleJson;

import com.google.gson.annotations.SerializedName;

/**
 * JSON Root node
 */
public class VehicleSearch {
    @SerializedName("Search")
    public VehicleList searchData;
}

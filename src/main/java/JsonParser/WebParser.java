package JsonParser;

import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.VehicleSearch;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebParser implements IJsonParser {

    private final String url = "http://www.rentalcars.com/js/vehicles.json";

    @Override
    public VehicleSearch getVehicleSearch() {
        try {
            URL jsonData = new URL(url);
            URLConnection connection = jsonData.openConnection();

            String jsonString = IOUtils.toString(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            Gson gson = new Gson();
            return gson.fromJson(jsonString, VehicleSearch.class);
        } catch (Exception e) {
            // Log
            return new VehicleSearch();
        }
    }

    @Override
    public VehicleSpec getVehicleSpec() {
        return null;
    }
}
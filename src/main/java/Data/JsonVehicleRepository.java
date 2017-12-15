package Data;

import JsonParser.IJsonParser;
import Model.ScoreJson.VehicleScore;
import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JsonVehicleRepository implements IRepository {

    final private IJsonParser parser;

    public JsonVehicleRepository(IJsonParser parser) {
        this.parser = parser;
    }

    /**
     * Get vehicle list with Sipp loaded
     * @return ArrayList<Vehicle>
     */
    @Override
    public ArrayList<Vehicle> getVehicleList() {
        return parser.getVehicleSearch().searchData.vehicles;
    }

    @Override
    public VehicleSpec getVehicleSpec() {
        return parser.getVehicleSpec();
    }

    @Override
    public VehicleScore getVehicleScore() {
        return parser.getVehicleScore();
    }
}
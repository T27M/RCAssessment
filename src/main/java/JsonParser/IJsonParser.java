package JsonParser;

import Model.ScoreJson.VehicleScore;
import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.VehicleSearch;

public interface IJsonParser {
    VehicleSearch getVehicleSearch();
    VehicleSpec getVehicleSpec();
    VehicleScore getVehicleScore();
}
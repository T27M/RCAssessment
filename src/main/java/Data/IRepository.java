package Data;

import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.Vehicle;

import java.util.ArrayList;

public interface IRepository {
    ArrayList<Vehicle> getVehicleList();
    VehicleSpec getVehicleSpec();
}
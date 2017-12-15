import Data.IRepository;
import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.Sipp;
import Model.VehicleJson.VehicleList;
import Service.CarSpec.CarSpec;
import Service.CarSpec.ICarSpec;
import org.junit.Assert;
import org.junit.Test;

public class TestCarSpec {

    IRepository testRepository() {
        return new IRepository() {
            @Override
            public VehicleList getVehicleList() {
                return new VehicleList();
            }

            @Override
            public VehicleSpec getVehicleSpec() {

                VehicleSpec spec = new VehicleSpec();

                spec.carType.put("T", "Test");

                spec.doorCarType.put("E", "2 door");
                spec.doorCarType.put("V", "Pick Up");

                spec.transmission.put("S", "Manual");
                spec.fuelAc.put("T", "Petrol/Ac");

                return spec;
            }
        };
    }

    @Test
    public void TestCreateSipp_DoorLetter()
    {
        ICarSpec spec = new CarSpec(testRepository());

        Sipp sipp = spec.getSipp("TEST");

        String actual = sipp.toString();
        String expected = "Economy - 4 doors - Manual - Petrol/no AC";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCreateSipp_MultipleLetter()
    {
        ICarSpec spec = new CarSpec(testRepository());

        Sipp sipp = spec.getSipp("TVET");

        String actual = sipp.toString();
        String expected = "Full size Passenger Van - Automatic - Petrol/AC";

        Assert.assertEquals(expected, actual);
    }
}
import Data.IRepository;
import Model.ScoreJson.VehicleScore;
import Model.SpecJson.VehicleSpec;
import Model.VehicleJson.Sipp;
import Model.VehicleJson.Vehicle;
import Model.VehicleJson.VehicleList;
import Service.CarScore.CarScore;
import Service.CarScore.ICarScore;
import Service.CarSpec.CarSpec;
import Service.CarSpec.ICarSpec;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tests {

    IRepository testRepository() {
        return new IRepository() {
            @Override
            public ArrayList<Vehicle> getVehicleList() {
                return new ArrayList<>();
            }

            @Override
            public VehicleSpec getVehicleSpec() {

                VehicleSpec spec = new VehicleSpec();

                spec.carType.put("T", "Test");

                // Door letter
                spec.doorLetters.add("E");
                spec.doorCarType.put("E", "2 door");

                spec.doorCarType.put("V", "Pick Up");

                spec.transmission.put("M", "Manual");
                spec.fuelAc.put("R", "Petrol/Ac");

                return spec;
            }

            @Override
            public VehicleScore getVehicleScore() {
                VehicleScore vehicleScore = new VehicleScore();

                vehicleScore.manualLetter = "M";
                vehicleScore.autoLetter = "A";
                vehicleScore.acLetter = "R";

                vehicleScore.manualTransmission = 1.0;
                vehicleScore.automaticTransmission = 2.0;
                vehicleScore.airConditioned = 3.0;

                return vehicleScore;
            }
        };
    }

    @Test
    public void TestCreateSipp_DoorLetter()
    {
        ICarSpec spec = new CarSpec(testRepository());

        Sipp sipp = spec.getSipp("TEMR");

        String actual = sipp.toString();
        String expected = "Test, 2 door - Manual - Petrol/Ac";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCreateSipp_MultipleLetter()
    {
        ICarSpec spec = new CarSpec(testRepository());

        Sipp sipp = spec.getSipp("TVMR");

        String actual = sipp.toString();
        String expected = "Test Pick Up - Manual - Petrol/Ac";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateScore_Manual() {
        ICarScore score = new CarScore(testRepository());

        Double actual = score.getScore("TEMN");
        Double expected = 1.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateScore_Manual_AC() {
        ICarScore score = new CarScore(testRepository());

        Double actual = score.getScore("TEMR");
        Double expected = 4.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateScore_Auto() {
        ICarScore score = new CarScore(testRepository());

        Double actual = score.getScore("TEAN");
        Double expected = 2.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCalculateScore_Auto_AC() {
        ICarScore score = new CarScore(testRepository());

        Double actual = score.getScore("TEAR");
        Double expected = 5.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSippPrint_NotCombined_Correct() {
        Sipp sipp = new Sipp(false, "TEST", "T", "E", "S", "T");

        String actual = sipp.toString();
        String expected = "T, E - S - T";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSippPrint_NotCombined_Wrong() {
        Sipp sipp = new Sipp(false, "TEST", "T", "E", "S", "T");

        String actual = sipp.toString();
        String expected = "T, E - S - E";

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void TestSippPrint_Combined_Correct() {
        Sipp sipp = new Sipp(true, "TEST", "T", "E", "S", "T");

        String actual = sipp.toString();
        String expected = "T E - S - T";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSippPrint_Combined_Wrong() {
        Sipp sipp = new Sipp(true, "TEST", "T", "E", "S", "T");

        String actual = sipp.toString();
        String expected = "T E - E - T";

        Assert.assertNotEquals(expected, actual);
    }
}
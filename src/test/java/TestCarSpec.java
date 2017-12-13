import Service.CarSpec.DefaultCarSpec;
import Service.CarSpec.ICarSpec;
import org.junit.Assert;
import org.junit.Test;

public class TestCarSpec {
    @Test
    public void TestGetSpec_DoorLetter()
    {
        ICarSpec spec = new DefaultCarSpec();

        String actual = spec.getSpec("ECMN");
        String expected = "Economy - 4 doors - Manual - Petrol/no AC";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestGetSpec_MultipleLetter()
    {
        ICarSpec spec = new DefaultCarSpec();

        String actual = spec.getSpec("FVAR");
        String expected = "Full size Passenger Van - Automatic - Petrol/AC";

        Assert.assertEquals(expected, actual);
    }
}
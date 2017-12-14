package Service.CarSpec;

import JsonParser.Sipp;

public interface ICarSpec {
    String getSpec(String sipp);
    String getCarType(String sipp);
    Sipp createSipp(String sipp);
}
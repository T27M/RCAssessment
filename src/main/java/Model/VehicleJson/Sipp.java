package Model.VehicleJson;

public class Sipp {

    // Determines how the string version will be printed
    private boolean combined;

    private String sipp;
    private String carType;
    private String carTypeDoors;
    private String transmission;
    private String fuelAc;

    public Sipp(boolean combined, String sipp, String carType, String carTypeDoors, String transmission, String fuelAc) {
        this.combined = combined;
        this.sipp = sipp;
        this.carType = carType;
        this.carTypeDoors = carTypeDoors;
        this.transmission = transmission;
        this.fuelAc = fuelAc;
    }

    public String getCarType() {
        return carType;
    }

    @Override
    public String toString() {

        String out = "";

        if(combined) {
            out += carType + " " + carTypeDoors + " - ";
        } else {
            out += carType + ", " + carTypeDoors + " - ";
        }

        out += transmission + " - " + fuelAc;

        return out;
    }
}
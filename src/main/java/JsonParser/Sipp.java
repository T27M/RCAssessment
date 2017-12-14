package JsonParser;

public class Sipp {

    private boolean combined = false;

    public String carType;
    public String carTypeDoors;
    public String transmission;
    public String fuelAc;

    public void setCombined() {
        combined = true;
    }

    public String getCarType() {
        if(combined) {
            return carType + " " + carTypeDoors;
        } else {
            return carType;
        }
    }

    @Override
    public String toString() {

        String out = "";

        if(combined) {
            out += carType + " " + carTypeDoors;
        } else {
            out += carType + ", " + carTypeDoors;
        }

        out += transmission + " " + fuelAc;

        return out;
    }
}

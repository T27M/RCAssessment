package Model.VehicleJson;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Vehicle {
    public String sipp;
    private Sipp _sipp;
    public Model.VehicleJson.Sipp Sipp;
    public String name;
    public BigDecimal price;
    public String supplier;
    public Double rating;

    @Override
    public String toString() {
        return name + " - " + new DecimalFormat("#0.##").format(price);
    }

    public String getSpec() {
        return name + " - " + sipp + " - " + _sipp.toString();
    }

    public Sipp get_sipp() {
        return _sipp;
    }

    public void set_sipp(Sipp _sipp) {
        this._sipp = _sipp;
    }
}
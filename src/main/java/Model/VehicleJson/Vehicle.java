package Model.VehicleJson;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Vehicle {
    public String sipp;
    private Sipp _sipp;
    public String name;
    public BigDecimal price;
    public String supplier;
    public Double rating;
    private Double _score;
    private Double _sum;

    public Double getRaiting() {
        return rating;
    }

    @Override
    public String toString() {
        return name + " - " + new DecimalFormat("#0.##").format(price);
    }

    public String getSpec() {
        return name + " - " + sipp + " - " + _sipp.toString();
    }

    public Sipp getSipp() {
        return _sipp;
    }

    public void setSipp(Sipp _sipp) {
        this._sipp = _sipp;
    }

    public Double getScore() {
        return _score;
    }

    public void set_score(Double _score) {
        this._score = _score;
    }

    public Double getSum() {
        _sum = _score + rating;
        return _sum;
    }
}
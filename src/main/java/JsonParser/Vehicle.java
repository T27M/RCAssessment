package JsonParser;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Vehicle {
    public String sipp;
    public String name;
    public BigDecimal price;
    public String supplier;
    public Double rating;

    @Override
    public String toString() {
        return name + " - " + new DecimalFormat("#0.##").format(price);
    }
}
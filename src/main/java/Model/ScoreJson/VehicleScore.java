package Model.ScoreJson;

import com.google.gson.annotations.SerializedName;

public class VehicleScore {
    @SerializedName("manual_letter")
    public String manualLetter;
    @SerializedName("manual_transmission")
    public Double manualTransmission;

    @SerializedName("auto_letter")
    public String autoLetter;
    @SerializedName("auto_transmission")
    public Double automaticTransmission;

    @SerializedName("ac_letter")
    public String acLetter;
    @SerializedName("air_conditioned")
    public Double airConditioned;
}
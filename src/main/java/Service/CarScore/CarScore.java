package Service.CarScore;

import Data.IRepository;
import Model.ScoreJson.VehicleScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarScore implements ICarScore {

    final private IRepository repository;

    @Autowired
    public CarScore(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public Double getScore(String sipp) {
        VehicleScore vehicleScore = this.repository.getVehicleScore();

        Double score = 0.0;

        char[] _sipp = sipp.toCharArray();

        if (Character.toString(_sipp[2]).equals(vehicleScore.manualLetter)) {
            score += vehicleScore.manualTransmission;
        } else if (Character.toString(_sipp[2]).equals(vehicleScore.autoLetter)) {
            score += vehicleScore.automaticTransmission;
        }

        if (Character.toString(_sipp[3]).equals(vehicleScore.acLetter)) {
            score += vehicleScore.airConditioned;
        }

        return score;
    }
}
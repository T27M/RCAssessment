package Web;

import Model.VehicleJson.Vehicle;
import Service.IRentalCars;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class RentalCarsController {

    @Autowired
    private IRentalCars rentalCars;

    @RequestMapping("/cars")
    @ResponseBody
    String getCars() {
        ArrayList<Vehicle> vehicles = rentalCars.getCars();

        Gson gson = new Gson();

        return gson.toJson(vehicles);
    }

    @RequestMapping("/cars/spec")
    @ResponseBody
    String getCarsSpec() {
        Collection<Vehicle> vehicles = rentalCars.getCarsWithSpec();

        Gson gson = new Gson();
        return gson.toJson(vehicles);
    }

    @RequestMapping("/cars/rating")
    @ResponseBody
    String getCarsRating() {
        Collection<Vehicle> vehicles = rentalCars.getCarsByRaiting();

        Gson gson = new Gson();
        return gson.toJson(vehicles);
    }

    @RequestMapping("/cars/score")
    @ResponseBody
    String getCarsScore() {
        ArrayList<Vehicle> vehicles = rentalCars.getCarsByScore();

        Gson gson = new Gson();
        return gson.toJson(vehicles);
    }
}

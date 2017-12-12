import JsonParser.SearchData;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Driver {


    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();

        String jsonFile = Driver.class.getClassLoader().getResource("vehicles.json").getFile();
        SearchData data = gson.fromJson(new FileReader(jsonFile), SearchData.class);




    }
}

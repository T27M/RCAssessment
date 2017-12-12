package JsonParser;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileParser implements IJsonParser {

    private final String filename = "vehicles.json";

    @Override
    public JsonRoot getData() throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonFile = FileParser.class.getClassLoader().getResource(filename).getFile();

        return gson.fromJson(new FileReader(jsonFile), JsonRoot.class);
    }
}

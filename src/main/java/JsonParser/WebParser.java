package JsonParser;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebParser implements IJsonParser {

    private final String url = "http://www.rentalcars.com/js/vehicles.json";

    @Override
    public SearchData GetData() throws IOException {

        URL jsonData = new URL(url);
        URLConnection connection = jsonData.openConnection();

        String jsonString = IOUtils.toString(new InputStreamReader(connection.getInputStream(), "UTF-8"));

        Gson gson = new Gson();
        return gson.fromJson(new FileReader(jsonString), SearchData.class);
    }
}

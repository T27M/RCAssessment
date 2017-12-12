package JsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface IJsonParser {
    SearchData GetData() throws IOException;
}

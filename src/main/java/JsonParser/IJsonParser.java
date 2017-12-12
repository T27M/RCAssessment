package JsonParser;

import java.io.IOException;

public interface IJsonParser {
    JsonRoot getData() throws IOException;
}
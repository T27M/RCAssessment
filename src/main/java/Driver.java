import JsonParser.FileParser;
import JsonParser.IJsonParser;
import JsonParser.SearchData;
import JsonParser.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Driver.class);

        IJsonParser parser = context.getBean(FileParser.class);

        SearchData data = parser.GetData();

        for (Vehicle vehicle : data.vehicles)
        {
            System.out.print(vehicle.toString());
        }
    }
}

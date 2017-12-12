import JsonParser.FileParser;
import JsonParser.IJsonParser;
import JsonParser.SearchData;
import JsonParser.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@Configuration
@ComponentScan("JsonParser")
public class Driver {

//    @Bean
//    IJsonParser mockDataService() {
//        return () -> {
//            SearchData d = new SearchData();
//            d.vehicles = new ArrayList<>();
//
//            Vehicle v = new Vehicle();
//
//            v.name = "test";
//            v.price = new BigDecimal(1.33);
//            v.raiting = 5.1;
//            v.sipp = "CDMR";
//            v.supplier = "Hertz";
//
//            d.vehicles.add(v);
//
//            return d;
//        };
//    }

    @Bean
    IJsonParser dataService() {
        return new FileParser();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Driver.class);
        IJsonParser parser = context.getBean(IJsonParser.class);

        SearchData data = parser.getData();
        for (Vehicle vehicle : data.vehicles)
        {
            System.out.print(vehicle.toString());
        }
    }
}

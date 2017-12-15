import JsonParser.FileParser;
import JsonParser.IJsonParser;
import Service.IRentalCars;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"Data", "JsonParser", "Service", "Service.CarSpec"})
public class Driver {

    @Bean
    IJsonParser jsonParser() {
        return new FileParser();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Driver.class);
        IRentalCars rcService = context.getBean(IRentalCars.class);

        System.out.println("\n== Cars - Ascending price order  ===\n");
        rcService.displayCars();

        System.out.println("\n== Spec ===\n");
        rcService.displaySpec();

        System.out.println("\n== Raiting - Decending raiting order ===\n");
        rcService.displayByRaiting();

        System.out.println("\n== Score - Decending sum order ===\n");
        rcService.displayByScore();
    }
}
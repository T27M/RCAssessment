import JsonParser.FileParser;
import JsonParser.IJsonParser;
import Service.IRentalCars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@ComponentScan({"Data", "Web", "JsonParser", "Service", "Service.CarSpec"})
public class Driver {

    @Bean
    IJsonParser jsonParser() {
        return new FileParser();
    }

    public static void ConsolePrint() {
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

    public static void WebApp(String[] args) {
        SpringApplication.run(Driver.class, args);
    }

    public static void main(String[] args) {
        ConsolePrint(); // Comment out if trouble
        WebApp(args);
    }
}
import JsonParser.FileParser;
import JsonParser.IJsonParser;
import Service.CarSpec.DefaultCarSpec;
import Service.CarSpec.ICarSpec;
import Service.IRentalCars;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"JsonParser", "Service", "Service.CarSpec"})
public class Driver {

    @Bean
    IJsonParser dataService() {
        return new FileParser();
    }

    @Bean
    ICarSpec carSpecService() {
        return new DefaultCarSpec();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Driver.class);
        IRentalCars rcService = context.getBean(IRentalCars.class);

        //rcService.displayCars();
        //rcService.displaySpec();

        // Not 100% clear if Compact is different to Compact Estate etc..
        //rcService.displayByRaiting();
        rcService.displayByScore();
    }
}

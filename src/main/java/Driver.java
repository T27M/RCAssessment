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

        //rcService.displayCars();
        //rcService.displaySpec()
        //rcService.displayByRaiting();
        rcService.displayByScore();
    }
}
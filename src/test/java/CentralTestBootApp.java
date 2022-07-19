import mate.academy.springboot.datajpa.DataJpaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@ComponentScan(basePackages = "com.ericsson.cas")
//@EnableConfigurationProperties
@EnableWebMvc
@SpringBootApplication
public class CentralTestBootApp {

    public static void main(String[] args) {
        SpringApplication.run(CentralTestBootApp.class, args);
    }
}
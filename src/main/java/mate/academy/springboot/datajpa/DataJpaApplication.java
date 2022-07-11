package mate.academy.springboot.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DataJpaApplication {

    public static void main(String[] args) {
        new MigrationExecutor().migrate();
        SpringApplication.run(DataJpaApplication.class, args);
    }
}

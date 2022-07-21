package springboot.datajpa.controller;

import springboot.datajpa.DataJpaApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = DataJpaApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Test
    public void getCategories() throws Exception {
        WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:8080")
                .build()
                .get()
                .uri("/categories/1")
            .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("name").isEqualTo("toys");

    }
}
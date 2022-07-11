//package cucumber;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.module.mockmvc.RestAssuredMockMvc;
//import java.util.ArrayList;
//import java.util.List;
//import mate.academy.springboot.datajpa.DataJpaApplication;
//import mate.academy.springboot.datajpa.model.dto.request.ProductRequestDto;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//@SpringBootTest(classes = DataJpaApplication.class)
//@ExtendWith(SpringExtension.class)
//@AutoConfigureMockMvc
//public class GetProductSnippet {
//    private static final String URL = "/products";
//    private List<ProductRequestDto> requestDtoList;
//    private ResultActions response;
//    @Autowired
//    private MockMvc mvc;
//
//    @BeforeAll
//    public void init() {
//        requestDtoList = new ArrayList<>();
//    }
//
//    @BeforeEach
//    void setUp() {
//        RestAssuredMockMvc.mockMvc(mvc);
//    }
//
//    @When("I try to get product with id {string}")
//    public void getCategories(String id) throws Exception {
//        System.out.println(mvc);
//        response = mvc.perform(get(URL + "/" + id));
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.name").value("toys"));
//    }
//
//    @Then("I receive in product with name {string}, price {string} and category id {string}")
//    public void receivedProductCheck(String name, String price, String categoryId) throws Exception {
//        response.andExpect(status().isOk());
//                //.andExpect(jsonPath("$.name").value("toys"));
//    }
//
//
//}
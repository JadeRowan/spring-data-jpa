package cucumber;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.springboot.datajpa.controller.ProductController;
import mate.academy.springboot.datajpa.model.dto.request.ProductRequestDto;
import mate.academy.springboot.datajpa.model.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


public class AddProductStep {
    private static final String URL = "/products";
    private List<ProductRequestDto> requestDtoList = new ArrayList<>();
    private List<ProductResponseDto> responseDtoList = new ArrayList<>();

    @Autowired
    private ProductController productController;

//    private MockMvc mvc;
//
//    public AddProductStep() {
//    }
//
//    public AddProductStep(MockMvc mvc) {
//        this.mvc = mvc;
//    }

    private ResultActions resultActions;

    @Given("a several products")
    public void a_product_object_in_db(DataTable table) {
        requestDtoList = table.asLists(String.class).stream()
                .skip(1)
                .map(l -> new ProductRequestDto(l.get(0),
                        Double.valueOf(l.get(1)),
                        Long.valueOf(l.get(2))))
                .collect(Collectors.toList());
        System.out.println(requestDtoList);
    }


    @When("I try to add those to db")
    public void i_ask_whether_it_s_Friday_yet() throws Exception {
//        System.out.println(mvc);
//        for (ProductRequestDto productRequestDto : requestDtoList) {
//
//            resultActions = mvc.perform(post(URL)
//                    .content(asJsonString(productRequestDto))
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON));
//        }
        requestDtoList.forEach(dto -> productController.createProduct(dto));
    }

    public static String asJsonString(final ProductRequestDto obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I receive in response objects with not null id")
    public void i_should_be_told() throws Exception {
//        resultActions.andExpect(jsonPath("$.id").exists());
    }
}

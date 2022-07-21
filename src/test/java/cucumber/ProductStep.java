package cucumber;

import static java.lang.String.format;
import static org.springframework.test.web.reactive.server.WebTestClient.bindToServer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import springboot.datajpa.model.dto.request.ProductRequestDto;
import springboot.datajpa.model.dto.response.ProductResponseDto;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

public class ProductStep {
    private static final String PRODUCTS_URL = "/products";
    private static final String BASE_URL = "http://localhost:8080";
    private WebTestClient.ResponseSpec responseSpec;

    @When("add product with {string}, {double} and {long} to db")
    public void addProductToDb(String title, Double price, Long categoryId) {
        responseSpec = saveProduct(new ProductRequestDto(title, price, categoryId));
    }

    @Then("I receive product with not null id, {string}, {double} and {long}")
    public void checkNotNullIdAndFieldsEqual(String title, Double price, Long categoryId) {
        ProductResponseDto actualProductResponseDto = responseSpec.expectStatus().isOk()
                .expectBody(ProductResponseDto.class).returnResult().getResponseBody();
        assert actualProductResponseDto.getId() != null;
        assertFieldsEqual(actualProductResponseDto, title, price, categoryId);
    }

    @When("I try to get product with {long}")
    public void getProductById(Long id) {
        responseSpec = getProduct(id);
    }

    @When("delete product from db by {long}")
    public void deleteProductById(Long id) {
        WebTestClient
                .bindToServer()
                .baseUrl(BASE_URL)
                .build()
                .delete()
                .uri(format("%s/%s", PRODUCTS_URL, id))
                .exchange();
    }

    @Then("there are no objects in db with {long}")
    public void checkThatThereAreNoObjectWithGivenId(Long id) {
        getProduct(id).expectStatus().isNoContent();
    }

    @When("update product with {long}, using {string}, {double} and {long}")
    public void updateProductWithIdUsingNewPriceAndCategoryId(Long productId, String title,
                                                              Double newPrice, Long categoryId) {
        ProductRequestDto updatedProductDto = new ProductRequestDto(title, newPrice, categoryId);
        bindToServer()
                .baseUrl(BASE_URL).build()
                .put()
                .uri(format("%s/%s", PRODUCTS_URL, productId))
                .body(Mono.just(updatedProductDto), ProductRequestDto.class)
                .exchange();
    }

    @Given("a product with {string}, {double} and {long} in db and have {long}")
    public void aProductWithPriceAndCategoryIdInDbAndHaveId(String title, Double price,
                                                            Long categoryId,
                                                            Long expectedProductId) {
        saveProduct(new ProductRequestDto(title, price, categoryId))
                .expectStatus().isOk()
                .expectBody().jsonPath("id").isEqualTo(expectedProductId);
    }

    @Then("there are a product in db with {long}, {string}, {double} and {long}")
    public void thereAreAProductInDbWithIdNewPriceAndCategoryId(Long productId, String title,
                                                                Double price, Long categoryId) {
        ProductResponseDto productResponseDto = getProduct(productId).expectStatus().isOk()
                .expectBody(ProductResponseDto.class).returnResult().getResponseBody();
        assertFieldsEqual(productResponseDto, title, price, categoryId);
    }

    private WebTestClient.ResponseSpec saveProduct(ProductRequestDto productRequestDto) {
        return bindToServer()
                .baseUrl(BASE_URL).build()
                .post()
                .uri(PRODUCTS_URL)
                .body(Mono.just(productRequestDto), ProductRequestDto.class)
                .exchange();
    }

    private WebTestClient.ResponseSpec getProduct(Long id) {
        return WebTestClient
                .bindToServer()
                .baseUrl(BASE_URL)
                .build()
                .get()
                .uri(format("%s/%s", PRODUCTS_URL, id))
                .exchange();
    }

    private void assertFieldsEqual(ProductResponseDto actualProductResponseDto, String title,
                                   Double price, Long categoryId) {
        assert actualProductResponseDto.getTitle().equals(title);
        assert actualProductResponseDto.getPrice().equals(price);
        assert actualProductResponseDto.getCategoryResponseDto()
                .getId().equals(categoryId);
    }
}

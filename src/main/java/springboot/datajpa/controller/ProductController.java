package springboot.datajpa.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import springboot.datajpa.mapper.ProductDtoMapper;
import springboot.datajpa.model.Product;
import springboot.datajpa.model.dto.request.ProductRequestDto;
import springboot.datajpa.model.dto.response.ProductResponseDto;
import springboot.datajpa.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductDtoMapper productDtoMapper;

    public ProductController(ProductService productService, ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        System.out.println(productRequestDto);
        Product product1 = productDtoMapper.toModel(productRequestDto);
        System.out.println(product1);
        Product product = productService.save(product1);
        System.out.println(product);
        return productDtoMapper.toDto(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {
        try {
            return ok(productDtoMapper.toDto(productService.get(id)));
        } catch (EntityNotFoundException e) {
            return noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id,
                                            @RequestBody ProductRequestDto productRequestDto) {
        Product product = productDtoMapper.toModel(productRequestDto);
        product.setId(id);
        return productDtoMapper.toDto(productService.save(product));
    }

    @GetMapping("/by-price")
    public List<ProductResponseDto> getByPriceBetween(@RequestParam BigDecimal min,
                                                      @RequestParam BigDecimal max) {
        return productService.getByPriceBetween(min, max).stream()
                .map(productDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-category")
    public List<ProductResponseDto> getByCategories(@RequestParam List<Long> categoryIds) {
        return productService.getByCategories(categoryIds).stream()
                .map(productDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}

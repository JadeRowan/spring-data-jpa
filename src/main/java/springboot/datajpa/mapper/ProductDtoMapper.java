package springboot.datajpa.mapper;

import java.math.BigDecimal;
import springboot.datajpa.model.Product;
import springboot.datajpa.model.dto.request.ProductRequestDto;
import springboot.datajpa.model.dto.response.ProductResponseDto;
import springboot.datajpa.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {
    private CategoryService categoryService;
    private CategoryDtoMapper categoryDtoMapper;

    public ProductDtoMapper(CategoryService categoryService, CategoryDtoMapper categoryDtoMapper) {
        this.categoryService = categoryService;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    public Product toModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setPrice(BigDecimal.valueOf(dto.getPrice()));
        product.setCategory(categoryService.get(dto.getCategoryId()));
        return product;
    }

    public ProductResponseDto toDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setPrice(product.getPrice().doubleValue());
        productResponseDto.setCategoryResponseDto(categoryDtoMapper.toDto(product.getCategory()));
        return productResponseDto;
    }
}

package springboot.datajpa.model.dto.response;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String title;
    private Double price;
    private CategoryResponseDto categoryResponseDto;
}

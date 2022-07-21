package springboot.datajpa.controller;

import springboot.datajpa.mapper.CategoryDtoMapper;
import springboot.datajpa.model.Category;
import springboot.datajpa.model.dto.request.CategoryRequestDto;
import springboot.datajpa.model.dto.response.CategoryResponseDto;
import springboot.datajpa.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryDtoMapper categoryDtoMapper;

    public CategoryController(CategoryService categoryService,
                              CategoryDtoMapper categoryDtoMapper) {
        this.categoryService = categoryService;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        Category category = categoryService.save(categoryDtoMapper.toModel(categoryRequestDto));
        return categoryDtoMapper.toDto(category);
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategory(@PathVariable Long id) {
        Category category = categoryService.get(id);
        return categoryDtoMapper.toDto(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@PathVariable Long id,
                                              @RequestBody CategoryRequestDto categoryRequestDto) {
        Category category = categoryDtoMapper.toModel(categoryRequestDto);
        category.setId(id);
        return categoryDtoMapper.toDto(categoryService.save(category));
    }
}

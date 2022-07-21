package springboot.datajpa.service;

import springboot.datajpa.model.Category;

public interface CategoryService {
    Category get(Long id);

    Category save(Category category);

    void delete(Long id);
}

package springboot.datajpa.service;

import java.math.BigDecimal;
import java.util.List;
import springboot.datajpa.model.Product;

public interface ProductService {
    Product save(Product product);

    Product get(Long id);

    void delete(Long id);

    List<Product> getByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> getByCategories(List<Long> categoryIds);
}

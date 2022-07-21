package springboot.datajpa.service.impl;

import java.math.BigDecimal;
import java.util.List;
import springboot.datajpa.dao.ProductRepository;
import springboot.datajpa.model.Product;
import springboot.datajpa.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getByPriceBetween(BigDecimal min, BigDecimal max) {
        return productRepository.getAllByPriceBetween(min, max);
    }

    @Override
    public List<Product> getByCategories(List<Long> categoryIds) {
        return productRepository.findAllByCategoryIn(categoryIds);
    }
}

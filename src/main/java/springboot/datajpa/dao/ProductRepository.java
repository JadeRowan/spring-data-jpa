package springboot.datajpa.dao;

import java.math.BigDecimal;
import java.util.List;
import springboot.datajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findAllByCategoryIn(List<Long> categoryIds);
}

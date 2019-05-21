package id.gits.springcodelabs1.ProductModule.Repositories;

import id.gits.springcodelabs1.ProductModule.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}

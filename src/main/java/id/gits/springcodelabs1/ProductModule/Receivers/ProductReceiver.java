package id.gits.springcodelabs1.ProductModule.Receivers;

import id.gits.springcodelabs1.ProductModule.Controllers.ProductController;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReceiver {

    Logger logger = LoggerFactory.getLogger(ProductReceiver.class);

    private final ProductRepository productRepository;

    public ProductReceiver(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> find(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product newData){
        return productRepository.save(newData);
    }

    public Product update(Long id,Product newData) {
        Optional<Product> find = productRepository.findById(id);
        return find.map((data) -> {
            if (find.isPresent()) data = mapDataForEdit(data,newData);
            else data = newData;
            return productRepository.save(data);
        }).orElseThrow(() -> new RuntimeException("Data Not Found"));
    }

    public Product delete(Long id){
        productRepository.deleteById(id);
        return null;
    }

    private Product mapDataForEdit(Product data,Product newData){
        data.setName(newData.getName());
        data.setPrice(newData.getPrice());
        data.setStock(newData.getStock());
        return data;
    }
}

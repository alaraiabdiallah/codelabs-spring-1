package id.gits.springcodelabs1.ProductModule.Receivers;

import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReceiver {

    Logger logger = LoggerFactory.getLogger(ProductReceiver.class);

    private final ProductRepository prodRepo;

    public ProductReceiver(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<Product> getAll(){
        return prodRepo.findAll();
    }

    public List<Product> searchByName(String keyword) {
        return prodRepo.searchProductByName(keyword);
    }

    public Optional<Product> find(Long id){
        return prodRepo.findById(id);
    }

    public Product save(Product newData){
        return prodRepo.save(newData);
    }

    public Product update(Long id,Product newData) {
        Optional<Product> find = prodRepo.findById(id);
        return find.map((data) -> {
            if (find.isPresent()) data = mapDataForEdit(data,newData);
            else data = newData;
            return prodRepo.save(data);
        }).orElseThrow(() -> new RuntimeException("Data Not Found"));
    }

    public Product delete(Long id){
        prodRepo.deleteById(id);
        return null;
    }

    private Product mapDataForEdit(Product data,Product newData){
        data.setName(newData.getName());
        data.setPrice(newData.getPrice());
        data.setStock(newData.getStock());
        return data;
    }
}

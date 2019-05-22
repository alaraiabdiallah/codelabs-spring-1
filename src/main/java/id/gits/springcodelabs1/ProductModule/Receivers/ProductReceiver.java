package id.gits.springcodelabs1.ProductModule.Receivers;

import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductReceiver {

    Logger logger = LoggerFactory.getLogger(ProductReceiver.class);

    private final ProductRepository prodRepo;

    public ProductReceiver(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<Product> getAll() throws EntityNotFoundException {
        return prodRepo.findAll();
    }

    public List<Product> searchByName(String keyword) {
        return prodRepo.searchProductByName(keyword);
    }

    public Product find(Long id) throws EntityNotFoundException{
        return prodRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Data Not Found"));
    }

    public Product save(Product newData){
        return prodRepo.save(newData);
    }

    public Product update(Long id,Product newData) throws Exception {
        try {
            Optional<Product> find = prodRepo.findById(id);
            Product data = find.get();
            if (find.isPresent()) data = mapDataForEdit(data,newData);
            else data = newData;
            return prodRepo.save(data);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public Product delete(Long id) throws Exception{
        try {
            prodRepo.deleteById(id);
            return null;
        }catch (Exception e){
            throw new Exception("Data with id: "+String.valueOf(id)+" Not Found");
        }
    }

    private Product mapDataForEdit(Product data,Product newData){
        data.setName(newData.getName());
        data.setPrice(newData.getPrice());
        data.setStock(newData.getStock());
        return data;
    }
}

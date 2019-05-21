package id.gits.springcodelabs1.ProductModule.Controllers;

import id.gits.springcodelabs1.Invokers.HttpInvoke;
import id.gits.springcodelabs1.ProductModule.Commands.DeleteProductRequest;
import id.gits.springcodelabs1.ProductModule.Commands.FindProductRequest;
import id.gits.springcodelabs1.ProductModule.Commands.GetAllProductsRequest;
import id.gits.springcodelabs1.ProductModule.Commands.UpdateProductRequest;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    HttpInvoke httpInvoke;

    /*public ProductController(){
        httpInvoke = new HttpInvoke();
    }*/

    @GetMapping
    public ResponseEntity<List<Product>> all(@RequestParam(required=false) String q){
        return httpInvoke.invoke(new GetAllProductsRequest(prodRepo));
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return prodRepo.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        return httpInvoke.invoke(new FindProductRequest(prodRepo,id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product newData) {
        return httpInvoke.invoke(new UpdateProductRequest(prodRepo,id,newData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable Long id) {
        return httpInvoke.invoke(new DeleteProductRequest(prodRepo,id));
    }

    private Product mapDataForEdit(Product data,Product newData){
        data.setName(newData.getName());
        data.setPrice(newData.getPrice());
        data.setStock(newData.getStock());
        return data;
    }
}

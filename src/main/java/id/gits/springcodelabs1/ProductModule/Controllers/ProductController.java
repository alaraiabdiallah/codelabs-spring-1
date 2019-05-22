package id.gits.springcodelabs1.ProductModule.Controllers;

import id.gits.springcodelabs1.Invokers.HttpInvoke;
import id.gits.springcodelabs1.ProductModule.Commands.*;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private GetAllProductsRequest getAllProductsRequest;

    @Autowired
    private CreateProductRequest createProductRequest;

    @Autowired
    private FindProductRequest findProductRequest;

    @Autowired
    private DeleteProductRequest deleteProductRequest;

    @Autowired
    private UpdateProductRequest updateProductRequest;

    @Autowired
    private HttpInvoke httpInvoke;

    @GetMapping
    public ResponseEntity<List<Product>> all(@RequestParam(required=false) String q){
        logger.info(q);
        getAllProductsRequest.setName(q);
        return httpInvoke.invoke(getAllProductsRequest);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        createProductRequest.setNewData(product);
        return httpInvoke.invoke(createProductRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        findProductRequest.setId(id);
        return httpInvoke.invoke(findProductRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product newData) {
        updateProductRequest.setId(id);
        updateProductRequest.setNewData(newData);
        return httpInvoke.invoke(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable Long id) {
        deleteProductRequest.setId(id);
        return httpInvoke.invoke(deleteProductRequest);
    }
}

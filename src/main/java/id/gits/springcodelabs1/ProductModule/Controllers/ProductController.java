package id.gits.springcodelabs1.ProductModule.Controllers;

import id.gits.springcodelabs1.Invokers.ApiResponseInvoke;
import id.gits.springcodelabs1.ProductModule.Commands.*;
import id.gits.springcodelabs1.ProductModule.Models.Product;
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
    private ApiResponseInvoke apiResponseInvoke;

    @GetMapping
    public ResponseEntity<List<Product>> all(@RequestParam(required=false) String q) throws Exception {
        getAllProductsRequest.setName(q);
        return apiResponseInvoke.invoke(getAllProductsRequest);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) throws Exception {
        createProductRequest.setNewData(product);
        return apiResponseInvoke.invoke(createProductRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) throws Exception {
        findProductRequest.setId(id);
        return apiResponseInvoke.invoke(findProductRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product newData) throws Exception {
        updateProductRequest.setId(id);
        updateProductRequest.setNewData(newData);
        return apiResponseInvoke.invoke(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable Long id) throws Exception {
        deleteProductRequest.setId(id);
        return apiResponseInvoke.invoke(deleteProductRequest);
    }
}

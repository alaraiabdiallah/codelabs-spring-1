package id.gits.springcodelabs1.ProductModule.Commands;

import id.gits.springcodelabs1.BaseCommand;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Receivers.ProductReceiver;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsRequest implements BaseCommand {

    private ProductReceiver productReceiver;

    public GetAllProductsRequest(ProductRepository repo){
        productReceiver = new ProductReceiver(repo);
    }

    @Override
    public List<Product> execute() {
        return productReceiver.getAll();
    }
}

package id.gits.springcodelabs1.ProductModule.Commands;

import id.gits.springcodelabs1.BaseCommand;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Receivers.ProductReceiver;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateProductRequest implements BaseCommand {

    @Autowired
    private ProductReceiver receiver;

    private Product data;

    public CreateProductRequest(ProductRepository repo, Product data){
        this.data = data;
        receiver = new ProductReceiver(repo);
    }

    @Override
    public Product execute() {
        return receiver.save(data);
    }
}

package id.gits.springcodelabs1.ProductModule.Commands;

import id.gits.springcodelabs1.BaseCommand;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Receivers.ProductReceiver;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;

public class UpdateProductRequest implements BaseCommand {
    private ProductReceiver receiver;

    private Long id;
    private Product data;

    public UpdateProductRequest(ProductRepository repo, Long id, Product newData){
        this.id = id;
        this.data = newData;
        receiver = new ProductReceiver(repo);
    }

    @Override
    public Product execute() {
        return receiver.delete(id);
    }
}

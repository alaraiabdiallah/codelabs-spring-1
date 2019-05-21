package id.gits.springcodelabs1.ProductModule.Commands;

import com.fasterxml.jackson.databind.ser.Serializers;
import id.gits.springcodelabs1.BaseCommand;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Receivers.ProductReceiver;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;

public class DeleteProductRequest implements BaseCommand {
    private ProductReceiver receiver;

    private Long id;

    public DeleteProductRequest(ProductRepository repo, Long id){
        this.id = id;
        receiver = new ProductReceiver(repo);
    }

    @Override
    public Product execute() {
        return receiver.delete(id);
    }
}

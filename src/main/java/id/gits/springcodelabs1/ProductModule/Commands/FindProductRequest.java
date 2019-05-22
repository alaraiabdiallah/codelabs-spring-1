package id.gits.springcodelabs1.ProductModule.Commands;

import id.gits.springcodelabs1.BaseCommand;
import id.gits.springcodelabs1.ProductModule.Models.Product;
import id.gits.springcodelabs1.ProductModule.Receivers.ProductReceiver;
import id.gits.springcodelabs1.ProductModule.Repositories.ProductRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class FindProductRequest implements BaseCommand {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReceiver productReceiver;

    @Setter
    private Long id;

    @Override
    public Product execute() {
        return productReceiver.find(this.id);
    }
}

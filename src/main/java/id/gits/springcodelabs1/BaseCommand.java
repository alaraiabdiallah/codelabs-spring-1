package id.gits.springcodelabs1;

import id.gits.springcodelabs1.ProductModule.Models.Product;

public interface BaseCommand<T> {

    T execute();
}

package rabbit.example.springbootrabbit.services;

import java.util.List;

import rabbit.example.springbootrabbit.commands.ProductForm;
import rabbit.example.springbootrabbit.domains.Product;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);

    void sendProductMessage(String id);
}
package rabbit.example.springbootrabbit.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import rabbit.example.springbootrabbit.commands.ProductForm;
import rabbit.example.springbootrabbit.domains.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}
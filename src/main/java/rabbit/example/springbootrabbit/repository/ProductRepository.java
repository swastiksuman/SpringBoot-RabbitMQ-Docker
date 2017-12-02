package rabbit.example.springbootrabbit.repository;

import org.springframework.data.repository.CrudRepository;

import rabbit.example.springbootrabbit.domains.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
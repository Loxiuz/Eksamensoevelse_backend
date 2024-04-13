package edu.eksamensoevelse.product;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name).orElseThrow(EntityNotFoundException::new);
    }

    public Product addProduct(Product request){
        return productRepository.save(request);
    }

    public Product editProduct(Product request, int id){
        Product productToEdit = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        updateProduct(productToEdit, request);
        return productRepository.save(productToEdit);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public void updateProduct(Product o, Product r){
        o.setName(r.getName());
        o.setPrice(r.getPrice());
        o.setWeightInGrams(r.getWeightInGrams());
    }

}


package edu.eksamensoevelse.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product request){
        return productService.addProduct(request);
    }

    @PutMapping("/{id}")
    public Product editProduct(@RequestBody Product request, int id){
        return productService.editProduct(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    public void updateProduct(Product o, Product r){
        o.setName(r.getName());
        o.setPrice(r.getPrice());
        o.setWeightInGrams(r.getWeightInGrams());
    }
}

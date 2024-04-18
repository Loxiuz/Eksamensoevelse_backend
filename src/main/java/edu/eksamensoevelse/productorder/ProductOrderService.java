package edu.eksamensoevelse.productorder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public List<ProductOrder> getAllProductOrders(){
    return productOrderRepository.findAll();
    }
}

package edu.eksamensoevelse.productorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productOrders")
public class ProductOrderController {

    ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
public List<ProductOrder> getAllProductOrders(){
        return productOrderService.getAllProductOrders();
    }
}

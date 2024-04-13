package edu.eksamensoevelse.delivery;

import edu.eksamensoevelse.productorder.ProductOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> getAllDeliveries(){
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}/orders")
    public List<ProductOrder> getDeliveryWithOrders(@PathVariable Long id){
        return deliveryService.getDeliveryWithOrders(id);
    }

    //TODO: Be able to get price in a deliver, changing, based on product orders

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery request){
        return deliveryService.createDelivery(request);
    }

    //TODO: Save(?) a delivery

    @PostMapping("/{id}/orders")
    public List<ProductOrder> addProductOrdersToDelivery(@PathVariable Long id, @RequestBody List<ProductOrder> orders) {
        return deliveryService.addProductOrdersToDelivery(id, orders);
    }
}

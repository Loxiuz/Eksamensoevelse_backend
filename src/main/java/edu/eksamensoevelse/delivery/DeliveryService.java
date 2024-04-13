package edu.eksamensoevelse.delivery;

import edu.eksamensoevelse.productorder.ProductOrder;
import edu.eksamensoevelse.productorder.ProductOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    DeliveryRepository deliveryRepository;
    ProductOrderRepository productOrderRepository;

    public DeliveryService(DeliveryRepository deliveryRepository, ProductOrderRepository productOrderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }

    public List<ProductOrder> getDeliveryWithOrders(Long id){
        return productOrderRepository.findProductOrdersByDeliveryId(id);
    }

    //TODO: Be able to get price, changing, based on product orders

    public Delivery createDelivery(Delivery request){
        return deliveryRepository.save(request);
    }

    //TODO: Save(?) a delivery

    public List<ProductOrder> addProductOrdersToDelivery(Long deliveryId, List<ProductOrder> orders) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);
        deliveryOptional.ifPresent(delivery -> orders.forEach(order -> order.setDelivery(delivery)));
        return orders.stream().map(order -> productOrderRepository.save(order)).toList();
    }


}

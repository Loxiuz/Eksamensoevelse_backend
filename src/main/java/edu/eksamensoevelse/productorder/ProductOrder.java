package edu.eksamensoevelse.productorder;

import edu.eksamensoevelse.delivery.Delivery;
import edu.eksamensoevelse.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Product product;
    @ManyToOne
    Delivery delivery;
    private int quantity;
}

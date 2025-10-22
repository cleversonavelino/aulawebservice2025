package br.pucpr.projetowebservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TAB_ORDER_ITEM")
@Data
public class OrderItem {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    private Integer quantity;
}

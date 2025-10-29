package br.pucpr.projetowebservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TAB_ORDER")
@Data
public class Order {

    @Id
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> itens;

    private LocalDateTime date;




}

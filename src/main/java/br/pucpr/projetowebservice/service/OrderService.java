package br.pucpr.projetowebservice.service;

import br.pucpr.projetowebservice.model.Order;
import br.pucpr.projetowebservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    @Transactional
    public Order save(Order order) {


        return orderRepository.save(order);
    }

}

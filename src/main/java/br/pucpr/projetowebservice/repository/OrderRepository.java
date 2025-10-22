package br.pucpr.projetowebservice.repository;

import br.pucpr.projetowebservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

package store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}

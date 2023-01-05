package store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.entities.ShirtEntity;

public interface ShirtRepository extends JpaRepository<ShirtEntity,Long> {
}

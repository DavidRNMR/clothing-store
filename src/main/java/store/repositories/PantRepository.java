package store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.entities.PantEntity;

public interface PantRepository extends JpaRepository<PantEntity,Long> {
}

package store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}

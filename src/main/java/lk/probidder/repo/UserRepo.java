package lk.probidder.repo;

import lk.probidder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
Author : Sachin Silva
*/
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}

package xyz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

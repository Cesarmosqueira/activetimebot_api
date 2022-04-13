package xyz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.Entities.Guild;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {
}

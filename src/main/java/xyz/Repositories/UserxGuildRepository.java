package xyz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.Entities.UserxGuild;

@Repository
public interface UserxGuildRepository extends JpaRepository<UserxGuild, Long> {
	@Query(value = "SELECT count(*) FROM userxguild WHERE guild_id = ?1 AND user_id = ?2", nativeQuery = true)
	Long exists_complete(Long guildId, Long userId);
}

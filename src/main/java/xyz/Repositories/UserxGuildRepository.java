package xyz.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.Entities.UserxGuild;

@Repository
public interface UserxGuildRepository extends JpaRepository<UserxGuild, Long> {
	@Query(value = "SELECT count(*) FROM userxguild WHERE guild_id = ?1 AND user_id = ?2", nativeQuery = true)
	Long exists_complete(Long guildId, Long userId);

	@Query(value = "SELECT user_id FROM userxguild WHERE guild_id = ?1", nativeQuery = true)
	List<Long> users_in_guild(Long guildId);

	@Modifying
	@Query(value = "UPDATE userxguild SET minutes = minutes + 1 WHERE guild_id=?1 AND user_id=?2", nativeQuery = true)
	int increment_active_minute(Long guildId, Long userId);

	@Query(value = "SELECT sum(minutes) FROM userxguild WHERE guild_id = ?1", nativeQuery = true)
	int minutes_sum(Long guild_id);

	@Modifying
	@Query(value = "UPDATE userxguild SET minutes = 0 WHERE guild_id = ?1", nativeQuery = true)
	int clear_minutes(Long guild_id);

	@Query(value = "SELECT minutes FROM userxguild WHERE guild_id=?1 AND user_id=?2", nativeQuery = true)
	Long get_user_minutes(Long guildId, Long userId);
}

package xyz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(UserxGuildRelationKey.class)
@Table(name = "userxguild")
@Data
@NoArgsConstructor
public class UserxGuild {
	@Id
	@Column(name = "guild_id")
	private Long guildId;
	@Id
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "minutes")
	private Long minutes;

	public UserxGuild(Long guildId, Long userId) {
		this.guildId = guildId;
		this.userId = userId;
		this.minutes = Long.valueOf(0);
	}
}

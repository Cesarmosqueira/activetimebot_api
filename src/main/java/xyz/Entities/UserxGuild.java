package xyz.Entities;

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
	private Long guildId;
	@Id
	private Long userId;

	public UserxGuild(Long guildId, Long userId) {
		this.guildId = guildId;
		this.userId = userId;
	}
}

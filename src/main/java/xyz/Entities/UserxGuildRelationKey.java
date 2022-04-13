package xyz.Entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserxGuildRelationKey implements Serializable {
	private Long guildId;
	private Long userId;
}

package xyz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xyz.Entities.Guild;
import xyz.Repositories.GuildRepository;

@Service
public class GuildService {
	@Autowired
	private GuildRepository guildRepository;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Guild createGuild(Guild guild) {
		return guildRepository.save(guild);
	}
}

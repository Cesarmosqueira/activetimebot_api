package xyz.Services;

import java.util.List;

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

	public String updateGuildList(List<Guild> guilds) {
		int updated = 0;
		int created = 0;
		for (Guild guild : guilds) {
			if (guildRepository.existsById(guild.getId())) {
				// If guild exists already skip
				updated += 1;
			} else {
				// if it doesn't, create it
				guildRepository.save(guild);
				created += 1;
			}
		}
		return String.format("Updated(%d) created(%d)", updated, created);
	}
}

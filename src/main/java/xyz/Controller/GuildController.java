package xyz.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.Entities.Guild;
import xyz.Services.GuildService;

@RestController
@RequestMapping("/guild")
public class GuildController {
	private final GuildService guildService;

	public GuildController(GuildService guildService) {
		this.guildService = guildService;
	}

	@PostMapping
	public ResponseEntity<String> updateGuildList(@RequestBody List<Guild> guilds) {
		String responseOutput = guildService.updateGuildList(guilds);
		return new ResponseEntity<>(responseOutput, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Guild> createGuild(@RequestBody Guild guild) {
		Guild newGuild = guildService.createGuild(guild);
		return new ResponseEntity<>(newGuild, HttpStatus.OK);
	}
}

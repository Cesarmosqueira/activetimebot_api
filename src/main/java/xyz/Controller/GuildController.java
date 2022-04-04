package xyz.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PutMapping
	public ResponseEntity<Guild> createGuild(@RequestBody Guild guild) {
		Guild newGuild = guildService.createGuild(guild);
		return new ResponseEntity<>(newGuild, HttpStatus.OK);
	}

}

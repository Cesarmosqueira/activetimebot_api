package xyz.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.Dtos.UserDto;
import xyz.Entities.Guild;
import xyz.Services.GuildService;
import xyz.Services.UserService;
import xyz.common.EntityDtoConverter;

@RestController
@RequestMapping("/guild")
public class GuildController {
	private final GuildService guildService;
	private final UserService userService;
	private final EntityDtoConverter entityDtoConverter;

	public GuildController(GuildService guildService, UserService userService, EntityDtoConverter entityDtoConverter) {
		this.guildService = guildService;
		this.userService = userService;
		this.entityDtoConverter = entityDtoConverter;
	}

	@PostMapping("update_guilds")
	public ResponseEntity<String> updateGuildList(@RequestBody List<Guild> guilds) {
		String responseOutput = guildService.updateGuildList(guilds);
		return new ResponseEntity<>(responseOutput, HttpStatus.OK);
	}

	@PostMapping("update_activetimes/{guild_id}")
	public ResponseEntity<String> updateActiveUsers(@RequestBody List<Long> activeUsersId, @RequestParam Long guildId) {
		int updated = guildService.updateActiveUsers(guildId, activeUsersId);
		return new ResponseEntity<>(String.format("Updated %d users in guild $d", updated, guildId),
				HttpStatus.OK);
	}

	@PostMapping("clear_minutes/{guild_id}")
	public ResponseEntity<String> clearMinutes(@RequestParam Long guildId) {
		int totalMinutes = guildService.clearMinutes(guildId);
		return new ResponseEntity<>(String.format("Total minutes cleared: %d", totalMinutes),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Guild> createGuild(@RequestBody Guild guild) {
		Guild newGuild = guildService.createGuild(guild);
		return new ResponseEntity<>(newGuild, HttpStatus.OK);
	}

	@GetMapping("users/{guildId}")
	public ResponseEntity<List<UserDto>> getByGuildId(@RequestParam Long guildId) {
		List<Long> userIds = guildService.getUserIdsByGuildId(guildId);
		return new ResponseEntity<>(entityDtoConverter.convertUserToDto(userService.convertIds(userIds)),
				HttpStatus.OK);
	}

}

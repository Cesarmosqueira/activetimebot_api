package xyz.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.Dtos.UserDto;
import xyz.Entities.User;
import xyz.Services.UserService;
import xyz.common.EntityDtoConverter;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	private final EntityDtoConverter entityDtoConverter;

	public UserController(UserService userService, EntityDtoConverter entityDtoConverter) {
		this.userService = userService;
		this.entityDtoConverter = entityDtoConverter;
	}

	@PutMapping
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto, @RequestParam Long guildId)
			throws Exception {
		User newUser = userService.createUser(userDto, guildId);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<UserDto> getById(@RequestParam Long userId) {
		UserDto userDto = entityDtoConverter.convertUserToDto(userService.findById(userId));
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@GetMapping("list/")
	public ResponseEntity<List<UserDto>> getAll() {
		return new ResponseEntity<>(entityDtoConverter.convertUserToDto(userService.findAll()), HttpStatus.OK);
	}

}

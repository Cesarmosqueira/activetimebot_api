package xyz.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.Dtos.UserDto;
import xyz.Entities.User;
import xyz.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PutMapping
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto, @RequestParam Long guildId)
			throws Exception {
		User newUser = userService.createUser(userDto, guildId);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
}

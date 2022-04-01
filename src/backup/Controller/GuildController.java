package xyz.activetime.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.activetime.Entities.Guild;

@RestController
@RequestMapping("/guild")
public class GuildController {

	@PostMapping
	public ResponseEntity<String> createCategories(@Validated @RequestBody Guild guild) {
		return new ResponseEntity<>("Post works", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<String> findAllCategories() {
		return new ResponseEntity<>("Get works", HttpStatus.OK);
	}
}

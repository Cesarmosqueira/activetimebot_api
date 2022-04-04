package xyz.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guild")
public class GuildController {

	@PostMapping
	public ResponseEntity<String> createCategories(@Valid @RequestBody Guild guild) {
		return new ResponseEntity<>("Post works", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<String> findAllCategories() {
		return new ResponseEntity<>("Get works", HttpStatus.OK);
	}
}

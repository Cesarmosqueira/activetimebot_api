package xyz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xyz.Dtos.UserDto;
import xyz.Entities.User;
import xyz.Entities.UserxGuild;
import xyz.Repositories.GuildRepository;
import xyz.Repositories.UserRepository;
import xyz.Repositories.UserxGuildRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserxGuildRepository userxGuildRepository;
	@Autowired
	private GuildRepository guildRepository;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public User createUser(UserDto userDto, Long guildId) {
		// Check guild id
		if (guildRepository.existsById(guildId)) {
			// checks if there are 0 repetitions of that relation
			if (userxGuildRepository.exists_complete(guildId, userDto.getId()) == 0) {
				UserxGuild relation = new UserxGuild(guildId, userDto.getId());
				// there is no way to validate if the user id is correct from the server side.
				userxGuildRepository.save(relation);
				// relation is saved and we save the user
				return userRepository.save(new User(userDto));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	// TODO rest of crud

	public User findById(Long userId) {
		User user = userRepository.getById(userId);
		return user;
	}

}

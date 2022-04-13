package xyz.common;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import xyz.Dtos.UserDto;
import xyz.Dtos.UserMinutesDto;
import xyz.Entities.User;

@Component
public class EntityDtoConverter {
	private final ModelMapper modelMapper;

	public EntityDtoConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public UserDto convertUserToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	public List<UserDto> convertUserToDto(List<User> users) {
		return users.stream().map(this::convertUserToDto).collect(Collectors.toList());
	}

	public UserMinutesDto convertUserToMinutesDto(User user, Long minutes) {
		return new UserMinutesDto(user, minutes);
	}
}

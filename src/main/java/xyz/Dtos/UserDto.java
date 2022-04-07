package xyz.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.Entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String userName;
	private Long minutesActive;

	public UserDto(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.minutesActive = user.getMinutesActive();
	}
}

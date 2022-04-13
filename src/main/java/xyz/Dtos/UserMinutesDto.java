package xyz.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.Entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMinutesDto {
	private Long id;
	private String userName;
	private Long minutes;

	public UserMinutesDto(User user, Long minutes) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.minutes = minutes;
	}
}

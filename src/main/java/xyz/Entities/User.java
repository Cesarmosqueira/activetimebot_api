package xyz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.Dtos.UserDto;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
	@Id
	@Column(name = "userId")
	private Long id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "minutesActive")
	private Long minutesActive;

	public User(UserDto userDto) {
		this.id = userDto.getId();
		this.userName = userDto.getUserName();
		this.minutesActive = userDto.getMinutesActive();
	}
}

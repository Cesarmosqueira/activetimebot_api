package xyz.Dtos;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	private String userName;
	private Long minutesActive;
}

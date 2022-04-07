package xyz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guild")
@Data
@NoArgsConstructor
public class Guild {
	@Id
	@Column(name = "id")
	private Long id;
}

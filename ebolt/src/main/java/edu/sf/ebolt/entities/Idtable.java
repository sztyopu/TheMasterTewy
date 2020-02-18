package edu.sf.ebolt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "idTable")
public class Idtable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id", nullable = false, unique = true)
	// private int id;
	//
	// private String uuid = UUID.randomUUID().toString();
	//
	//
	// @NotBlank
	// @Column(length = 60, name = "name", nullable = false, unique = true)
	// private String name;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private UUID id;
	//
	// private String title;

}

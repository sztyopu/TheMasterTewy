package edu.sf.ebolt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter @Setter
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "application_id")
//	@Size(max = 24)
	private String applicationId;
	
	
	@NotBlank
	@Column(length = 100, name = "productName", nullable = false, unique = true)
	private String productName;
	
	@Min(1)
	@Column(name = "items", nullable = false)
	private int items;
	
	
	@Column(length = 200, name = "description")
	@Length(min = 0, max = 200)
	private String description;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss")	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
//	@PrePersist
//	protected void onCreate() {
//	    date = new Date();
//	}
	
}






package com.vijay.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE_TABLE")
public class Employee implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7092826861372364811L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Size(min=4,max=8)
	private String name;
	@Min(10000)
	@Max(100000)
	private Double salary;
	@NotNull
	private String role;
	@NotNull
    private Long number;
}

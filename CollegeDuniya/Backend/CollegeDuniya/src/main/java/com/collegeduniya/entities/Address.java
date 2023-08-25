package com.collegeduniya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address{
	
	@Column(name="adr_line1",length=100)
	private String adrLine1;
	@Column(name="adr_line2",length=100)
	private String adrLine2;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private String country;
	
	@Id
	@Column(length=20)
	private String pincode;
	
	//one-to-one , uni dir Address 1--->1 Student
	//owning side : Address (since FK)
	
	@OneToOne
	@MapsId("id")
	private Student student;
	
	@OneToOne
	@MapsId("id")
	private Professor professor;
}
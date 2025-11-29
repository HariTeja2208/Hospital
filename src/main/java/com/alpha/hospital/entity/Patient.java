package com.alpha.hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Length(min=5,max=20)
	private String name;
	@Length(min=5,max=20)
	private String disease;
	private String gender;
	private int age;
	private String bloodgroup;
	private int bp;
	private int sugarlevel;
	
	//getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public int getBp() {
		return bp;
	}
	public void setBp(int bp) {
		this.bp = bp;
	}
	public int getSugarlevel() {
		return sugarlevel;
	}
	public void setSugarlevel(int sugarlevel) {
		this.sugarlevel = sugarlevel;
	}
	public Patient( @Length(min = 5, max = 20) String name, @Length(min = 5, max = 20) String disease,String gender, int age,
			String bloodgroup, int bp, int sugarlevel) {
		super();
		this.name = name;
		this.disease = disease;
		this.gender = gender;
		this.age = age;
		this.bloodgroup = bloodgroup;
		this.bp = bp;
		this.sugarlevel = sugarlevel;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", disease=" + disease + ",gender=" +gender+ ",age=" + age + ", bloodgroup="
				+ bloodgroup + ", bp=" + bp + ", sugarlevel=" + sugarlevel + "]";
	}
	
	
}


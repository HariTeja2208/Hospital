package com.alpha.hospital.dto;

public class Patientdto {
	private String name;
	private int age;
	private String disease;
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Patientdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patientdto(String name, int age, String disease,String gender) {
		super();
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Patientdto [name=" + name + ", age=" + age + ", disease=" + disease + ",gender ="+gender+"]";
	}
}

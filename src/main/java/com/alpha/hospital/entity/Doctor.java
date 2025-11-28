package com.alpha.hospital.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Doctor {
	@Id
	private int id;
	private String name;
	private String specialization;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Patient> plist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public List<Patient> getPlist() {
		return plist;
	}
	public void setPlist(List<Patient> plist) {
		this.plist = plist;
	}
	public Doctor(int id, String name, String specialization, List<Patient> plist) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.plist = plist;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", plist=" + plist + "]";
	}
	
}

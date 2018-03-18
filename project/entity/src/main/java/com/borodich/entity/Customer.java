package com.borodich.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.borodich.entity.api.AbstractBaseEntity;

@Entity
@Table(name="customer")
public class Customer extends AbstractBaseEntity{
	private static final long serialVersionUID = -8335190571849701588L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String eMail;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "customer")	
	private List<Chek> cheks;

	public Customer(){
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Chek> getCheks() {
		return cheks;
	}

	public void setCheks(List<Chek> cheks) {
		this.cheks = cheks;
	}
}
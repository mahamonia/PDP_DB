package com.borodich.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.borodich.entity.api.AbstractBaseEntity;

@Entity
public class Vendor extends AbstractBaseEntity{
	private static final long serialVersionUID = 2243220376669935489L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="status")
	private Boolean satus;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "vendor")
	private List<Chek> cheks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getSatus() {
		return satus;
	}

	public void setSatus(Boolean satus) {
		this.satus = satus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chek> getCheks() {
		return cheks;
	}

	public void setCheks(List<Chek> cheks) {
		this.cheks = cheks;
	}
}

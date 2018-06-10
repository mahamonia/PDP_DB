package com.borodich.entity;

import com.borodich.entity.api.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Vendor extends AbstractBaseEntity {
    private static final long serialVersionUID = 2243220376669935489L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private Boolean satus;// 0 - free

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "vendor")
    @JsonIgnore
    private List<Chek> cheks;

    public Vendor() {
    }
    
    public Vendor(String nameNew) {
	this.name = nameNew;
    }
    
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
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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "section")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Section extends AbstractBaseEntity {
    private static final long serialVersionUID = 1652188885757279448L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "section")
    @JsonIgnore
    private List<Product> products;

    public Section() {
    }

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public List<Product> getProducts() {
	return products;
    }

    public void setProducts(List<Product> products) {
	this.products = products;
    }
}
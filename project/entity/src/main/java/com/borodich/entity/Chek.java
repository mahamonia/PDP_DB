package com.borodich.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.borodich.entity.api.AbstractBaseEntity;

@Entity
public class Chek extends AbstractBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "number")
	private String number;

	@Column(name = "isPaid")
	private Boolean isPaid;

	@Temporal(TemporalType.DATE)
	private Date dateStart;

	@Temporal(TemporalType.DATE)
	private Date dateFinish;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_fk")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_fk")
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adress_fk")
	private Adress adress;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Cheks", joinColumns = { @JoinColumn(name = "product_fk") }, 
								inverseJoinColumns = {@JoinColumn(name = "chek_fk") })
	private List<Product> products;

	public Chek() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean isPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
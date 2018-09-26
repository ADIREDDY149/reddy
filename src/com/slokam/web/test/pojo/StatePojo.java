package com.slokam.web.test.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class StatePojo {

	private Integer id;
	private String name;
	
	private Countrypojo country;
	
	@ManyToOne
	@JoinColumn(name="cid")
	public Countrypojo getCountry() {
		return country;
	}
	public void setCountry(Countrypojo country) {
		this.country = country;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
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
}

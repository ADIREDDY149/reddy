package com.slokam.web.test.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Countrypojo {

	private Integer id;
	private String name;
	private String description;
	private List<StatePojo> states;
	
	@OneToMany(mappedBy="country")
	public List<StatePojo> getStates() {
		return states;
	}
	public void setStates(List<StatePojo> states) {
		this.states = states;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

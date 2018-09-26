package com.slokam.sc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class billpojo {
private Integer id;

private Integer quan;
private String bname;
private String baddress;
@Id
@GeneratedValue
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getQuan() {
	return quan;
}
public void setQuan(Integer quan) {
	this.quan = quan;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBaddress() {
	return baddress;
}
public void setBaddress(String baddress) {
	this.baddress = baddress;
}
}

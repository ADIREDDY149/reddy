package com.slokam.web.test.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="audit")
public class AuditPojo {
	
	@Id
	@GeneratedValue
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPreValue() {
		return preValue;
	}
	public void setPreValue(String preValue) {
		this.preValue = preValue;
	}
	public String getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getHappendAt() {
		return happendAt;
	}
	public void setHappendAt(Date happendAt) {
		this.happendAt = happendAt;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
private Integer id;
private String preValue;
private String currentValue;
private String propertyName;
private String className;
private Date happendAt;
private String uid;

}

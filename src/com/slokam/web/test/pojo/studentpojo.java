package com.slokam.web.test.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="student")
public class studentpojo {
private Integer id;
private String name;
private Integer age;
private String qual;
private Integer phone;
private Integer selectedCountry;

private Integer selectedState;

private MultipartFile fileData;
@Transient
public MultipartFile getFileData() {
	return fileData;
}
public void setFileData(MultipartFile fileData) {
	this.fileData = fileData;
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
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getQual() {
	return qual;
}
public void setQual(String qual) {
	this.qual = qual;
}
public Integer getPhone() {
	return phone;
}
public void setPhone(Integer phone) {
	this.phone = phone;
}public Integer getSelectedCountry() {
	return selectedCountry;
}
public void setSelectedCountry(Integer selectedCountry) {
	this.selectedCountry = selectedCountry;
}
public Integer getSelectedState() {
	return selectedState;
}
public void setSelectedState(Integer selectedState) {
	this.selectedState = selectedState;
}
}

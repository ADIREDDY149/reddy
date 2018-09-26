package com.slokam.web.test.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class GranntedAuthorityImpl implements GrantedAuthority {
	private Integer rid;

	@Id
	@GeneratedValue
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/*
	 * private List<UserDetailsImpl> users;
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable(name="user_roles", joinColumns={@JoinColumn(name="rid")},
	 * inverseJoinColumns={@JoinColumn(name="uid")} ) public
	 * List<UserDetailsImpl> getUsers() { return users; } public void
	 * setUsers(List<UserDetailsImpl> users) { this.users = users; }
	 */

	private String authority;

	@Column(name="name")
	public String getAuthority() {

		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}

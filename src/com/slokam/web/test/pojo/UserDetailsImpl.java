package com.slokam.web.test.pojo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class UserDetailsImpl implements UserDetails {

	private Integer uid;

	@Id
	@GeneratedValue
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	private Collection<GranntedAuthorityImpl> authorities;

	public void setAuthorities(Collection<GranntedAuthorityImpl> authorities) {
		this.authorities = authorities;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
			@JoinColumn(name = "rid") })
	public Collection<GranntedAuthorityImpl> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	private String password;

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "username")
	private String username;

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private boolean accountNonExpired;

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	private boolean accountNonLocked;

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	private boolean credentialsNonExpired;

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	private boolean enabled;

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}

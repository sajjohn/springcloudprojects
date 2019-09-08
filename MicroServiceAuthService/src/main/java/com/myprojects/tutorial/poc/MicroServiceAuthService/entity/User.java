/*package com.myprojects.tutorial.poc.MicroServiceAuthService.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class User implements UserDetails{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="user_id")
private Long userId;

@Column(name="user_name")
private String username;

@Column(name="password")
private String password;


@Column(name="account_expired")
private boolean accountExpired;



@Column(name="account_locked")
private boolean accountLocked;


@Column(name="CREDENTIALS_EXPIRED")
private boolean credentialsExpired;



@Column(name="ENABLED")
private boolean enabled;

public boolean isEnabled() {
	return enabled;
}



public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}



@ManyToMany(fetch=FetchType.LAZY)
@JoinTable(name="user_authority", joinColumns= @JoinColumn(name="user_id"), inverseJoinColumns= @JoinColumn(name="authority_id"))
private Set<Authority> authorities;







public Set<Authority> getAuthorities() {
	return authorities;
}



public void setAuthorities(Set<Authority> authorities) {
	this.authorities = authorities;
}



public Long getUserId() {
	return userId;
}



public void setUserId(Long userId) {
	this.userId = userId;
}



public String getUsername() {
	return username;
}

@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return !isAccountExpired();
	}


	@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return !isCredentialsExpired();
		}
	
	@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return !isAccountLocked();
		}
	



public void setUsername(String username) {
	this.username = username;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public boolean isAccountExpired() {
	return accountExpired;
}



public void setAccountExpired(boolean accountExpired) {
	this.accountExpired = accountExpired;
}



public boolean isAccountLocked() {
	return accountLocked;
}



public void setAccountLocked(boolean accountLocked) {
	this.accountLocked = accountLocked;
}



public boolean isCredentialsExpired() {
	return credentialsExpired;
}



public void setCredentialsExpired(boolean credentialsExpired) {
	this.credentialsExpired = credentialsExpired;
}









	
}
*/
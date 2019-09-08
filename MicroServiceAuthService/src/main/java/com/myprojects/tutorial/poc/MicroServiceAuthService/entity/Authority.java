/*package com.myprojects.tutorial.poc.MicroServiceAuthService.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="authority")
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="authority_id")
	private Long authorityId;
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return getAuthority_name();
	}

	

	

	

	public Long getAuthorityId() {
		return authorityId;
	}







	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}







	public String getAuthority_name() {
		return authority_name;
	}







	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}







	@Column(name="authority_name")
	private String authority_name;

}
*/
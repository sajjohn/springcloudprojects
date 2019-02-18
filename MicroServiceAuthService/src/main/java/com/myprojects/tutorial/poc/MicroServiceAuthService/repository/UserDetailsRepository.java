package com.myprojects.tutorial.poc.MicroServiceAuthService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myprojects.tutorial.poc.MicroServiceAuthService.entity.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
	
	@Query("select user from User user INNER JOIN FETCH user.authorities where user.username=:username")
	public User findByUsername(@Param("username") String username);

}

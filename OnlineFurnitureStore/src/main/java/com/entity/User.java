package com.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/*Reference: https://www.viralpatel.net/hibernate-inheritence-table-per-hierarchy-mapping/
 * */

@Entity
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String username;
	private String password;
	private String role;

	public User() {
	}

	public User(int uid, String username, String password, String role) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
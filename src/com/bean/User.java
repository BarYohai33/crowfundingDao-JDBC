package com.bean;

import java.io.Serializable; 


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="email", unique=true)
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private Boolean isConnected;
    
    public User ( String email, String password, String firstname, String lastname, Boolean isConnected) {
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.isConnected = isConnected;
	}
    
    public Boolean getisConnected() {
		return isConnected;
	}

	public void setisConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User ( ) { }
    //setters, getters, equals and hashcode
}
package com.bladir.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="role_name", unique=true)
	private String roleName;
	
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY,
			cascade={CascadeType.DETACH,CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
	private List<User> users;

	public Role() {
		
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

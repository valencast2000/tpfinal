package com.coop.tpfinal.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable,UserDetails {

	private static final long serialVersionUID = 1443830057482076964L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUser;
	
	@Column(length=100, nullable=false)
	private String firstName;
	
	@Column(length=100, nullable=false)
	private String lastName;
	
	@Column(length=100,unique=true, nullable=false)
	private String email; 
	
	@Column(length=50,unique=true, nullable=false)
	private String username;
	
	@Column(length=50, nullable=false)
	private String password;
	
	@Column(columnDefinition="tinyint(4) default '1'")
	private boolean enabled;
	
	
	public long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(columnDefinition="tinyint(4) default '1'")
	private boolean accountNonExpired;
	@Column(columnDefinition="tinyint(4) default '1'")
	private boolean accountNonLocked;
	@Column(columnDefinition="tinyint(4) default '1'")
	private boolean credentialsNonExpired;

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuariosroles",
	joinColumns= 
		{@JoinColumn(name="id_user", referencedColumnName = "idUser")},
	inverseJoinColumns = 
		{@JoinColumn(name="id_rol",referencedColumnName = "id")}
	)
	private Set<Rol> roles;
	
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		//for (Rol rol : getRoles()) {
		//	SimpleGrantedAuthority sga=new SimpleGrantedAuthority(rol.getRol()); 
		//	authorities.add(sga);
		//}
		
		//List<GrantedAuthority> authorities=getRoles().stream()
		//		.map(rol -> new SimpleGrantedAuthority(rol.getRol()))
		//		.collect(Collectors.toList());
		//return authorities;
		
		
		
		return getRoles().stream()
			.map(rol -> new SimpleGrantedAuthority(rol.getRol()))
			.collect(Collectors.toList());
		
		
	}

	
	
}

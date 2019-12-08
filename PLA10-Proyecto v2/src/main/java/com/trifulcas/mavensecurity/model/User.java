package com.trifulcas.mavensecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class User {
  @Id
  @Column(name = "username")
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  private Set<Authorities> authorities = new HashSet<>();
  
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
	  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	this.password = encoder.encode(password);
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Set<Authorities> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<Authorities> authorities) {
    this.authorities = authorities;
  }
}
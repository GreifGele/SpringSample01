package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

  private String username = "";
  private String password = "";
  private List<GrantedAuthority> authorities = new ArrayList<>();
  private boolean enabled = true;
  private boolean credentialsNonExpired = true;
  private boolean accountNonLocked = true;
  private boolean accountNonExpired = true;

  public UserDetailsImpl() {
    this.authorities = AuthorityUtils.createAuthorityList("USER");
  }

  public UserDetailsImpl(String username, String password, String authority) {
    this();
    this.username = username;
    this.password = password;
    this.authorities = AuthorityUtils.createAuthorityList(authority);
  }
}

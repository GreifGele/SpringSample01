package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper=false)
public class UserEntity extends CommonEntity implements UserDetails
{
    @Id
	@NotBlank
    @Column(name = "name")
	private String username = "";
	@NotBlank
    @Column(name = "password")
	private String password = "";
	@Range(min = 0, max = 2)
    @Column(name = "type")
	private int type = 0;
    @Column(name = "fail_count")
	private int failCount = 0;
    @Column(name = "valid")
	private int valid = 0;

    @Transient
	private List<GrantedAuthority> authorities = new ArrayList<>();
    @Transient
	private boolean enabled = true;
    @Transient
	private boolean credentialsNonExpired = true;
    @Transient
	private boolean accountNonLocked = true;
    @Transient
	private boolean accountNonExpired = true;

	public UserEntity() {
	}

	public void CreateAuthorityList() {
		this.authorities = AuthorityUtils.createAuthorityList(this.type == 0 ? "USER" : "ADMIN");
	}
}

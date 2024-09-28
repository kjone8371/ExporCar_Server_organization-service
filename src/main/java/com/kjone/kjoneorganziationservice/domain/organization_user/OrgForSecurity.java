package com.kjone.kjoneorganziationservice.domain.organization_user;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@Builder
public class OrgForSecurity implements UserDetails {

    private final PasswordEncoder passwordEncoder;

    @NonNull
    private Organization_User organization_user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return organization_user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return organization_user.getPassword();
    }

    @Override
    public String getUsername() {
        return organization_user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

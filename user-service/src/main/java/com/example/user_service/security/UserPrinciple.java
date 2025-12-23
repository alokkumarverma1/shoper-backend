package com.example.user_service.security;

import com.example.user_service.entity.Register;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

   private Register register;

    public UserPrinciple(Register register) {
        this.register = register;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return register.getRoles()
                .stream().map(rolesdto ->
                        new SimpleGrantedAuthority("ROLE_" + rolesdto.getRolename()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return register.getPassword();
    }

    @Override
    public String getUsername() {
        return register.getNumber().toString(); // ya email
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.example.handyman.security;

import com.example.handyman.entity.Role;
import com.example.handyman.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public static SecurityUser createUserDetails(UserEntity userEntity) {
        return new SecurityUser(userEntity.getLogin(), userEntity.getPassword(), mapToGrantedAuthority(userEntity.getRoles()), userEntity.getStatus().equals("ACTIVE"));
    }

    public static List<GrantedAuthority> mapToGrantedAuthority(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

package com.example.handyman.entity.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Role {
    ADMIN(Stream.of(Permission.HANDYMAN_READ, Permission.HANDYMAN_WRITE, Permission.ORDERS_READ, Permission.ORDERS_WRITE).collect(Collectors.toSet())),
    HANDYMAN(Stream.of(Permission.ORDERS_READ).collect(Collectors.toSet())),
    CUSTOMER(Stream.of(Permission.HANDYMAN_READ).collect(Collectors.toSet()));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}

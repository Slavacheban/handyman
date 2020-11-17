package com.example.handyman.entity.enums;

public enum Permission {
    HANDYMAN_READ("handyman:read"),
    HANDYMAN_WRITE("handyman:write"),
    ORDERS_READ("orders:read"),
    ORDERS_WRITE("orders:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

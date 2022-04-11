package kz.gesti9.authorizationandrolls.model;

public enum Permission {
    EMPLOYEES_READ("employees:read"),
    EMPLOYEES_WRITE("employees:write");

    private final String permission;

    Permission(String permisson){
        this.permission = permisson;
    }

    public String getPermission() {
        return permission;
    }
}

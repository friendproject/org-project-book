package com.test.velocity.Beans;

/**
 * Created by Ankur on 05-10-2015.
 */
public class UserDetails
{

    private String userName;

    private String password;

    private String name;

    private Role role;

    public UserDetails(String userName, String password, String name, Role role) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}

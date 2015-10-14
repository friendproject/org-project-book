package com.test.velocity.Builder;

import com.test.velocity.Beans.Role;
import com.test.velocity.Beans.UserDetails;

/**
 * Created by Ankur on 11-10-2015.
 */
public class UserDetailsBuilder {
    private String userName;

    private String password;

    private String name;

    private Role role;

    public UserDetailsBuilder userName(String userName) {
        this.userName=userName;
        return this;
    }
    public UserDetailsBuilder password(String password) {
        this.password=password;
        return this;
    }
    public UserDetailsBuilder name(String name) {
        this.name=name;
        return this;
    }
    public UserDetailsBuilder role(Role role) {
        this.role=role;
        return this;
    }

    public UserDetails build(){
        return new UserDetails(userName,password,name,role);
    }

}

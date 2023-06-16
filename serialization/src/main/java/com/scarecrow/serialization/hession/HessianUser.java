package com.scarecrow.serialization.hession;

import java.io.Serializable;

/**
 * @author wangbo
 * @since 2023/6/16 11:02
 */
public class HessianUser implements Serializable {
    private String username;
    private Integer password;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

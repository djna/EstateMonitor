package org.djna.asynch.estate.data;

public class User {

    private String user;
    private String password;

    public User (String initUser, String initPassword){
        user = initUser;
        password = initPassword;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

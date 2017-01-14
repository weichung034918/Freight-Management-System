package model;

import Constants.AccessLevel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account{

    private String username;

    private String password;

    private AccessLevel level;

    public Account(){}

    public Account(String username, String password, AccessLevel level) {
        this.username = username;
        this.password = password;
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Account){
            if(((Account) obj).getUsername().equals(this.getUsername()))
                return true;
        }
        return false;
    }

    public AccessLevel getLevel() {
        return level;
    }

    public void setLevel(AccessLevel level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

package com.example.pawan.retrofitlogin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pawan on 10/14/2016.
 */

public class ServerResponse {

 private int SUCCESS;
    private String MESSAGE;
    private UsersVisitors usersvisitors;

    public int getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(int SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public UsersVisitors getUsersvisitors() {
        return usersvisitors;
    }

    public void setUsersvisitors(UsersVisitors usersvisitors) {
        this.usersvisitors = usersvisitors;
    }
}

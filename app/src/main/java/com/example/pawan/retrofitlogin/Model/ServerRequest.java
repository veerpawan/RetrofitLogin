package com.example.pawan.retrofitlogin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pawan on 10/14/2016.
 */

public class ServerRequest {

  /*   private int scheme_id;
    private String scheme_type;
    private String scheme_title;
    private String scheme_detail;
    private String scheme_weblink;
    private String scheme_made_on;
    private int scheme_created_by;
    private String scheme_created_on;
    private int scheme_active;

    public int getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(int scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getScheme_type() {
        return scheme_type;
    }

    public void setScheme_type(String scheme_type) {
        this.scheme_type = scheme_type;
    }

    public String getScheme_title() {
        return scheme_title;
    }

    public void setScheme_title(String scheme_title) {
        this.scheme_title = scheme_title;
    }

    public String getScheme_detail() {
        return scheme_detail;
    }

    public void setScheme_detail(String scheme_detail) {
        this.scheme_detail = scheme_detail;
    }

    public String getScheme_weblink() {
        return scheme_weblink;
    }

    public void setScheme_weblink(String scheme_weblink) {
        this.scheme_weblink = scheme_weblink;
    }

    public String getScheme_made_on() {
        return scheme_made_on;
    }

    public void setScheme_made_on(String scheme_made_on) {
        this.scheme_made_on = scheme_made_on;
    }

    public int getScheme_created_by() {
        return scheme_created_by;
    }

    public void setScheme_created_by(int scheme_created_by) {
        this.scheme_created_by = scheme_created_by;
    }

    public String getScheme_created_on() {
        return scheme_created_on;
    }

    public void setScheme_created_on(String scheme_created_on) {
        this.scheme_created_on = scheme_created_on;
    }

    public int getScheme_active() {
        return scheme_active;
    }

    public void setScheme_active(int scheme_active) {
        this.scheme_active = scheme_active;
    }*/
    private UsersVisitors UsersVisitors;

   private String MESSAGE;
    private int SUCCESS;


    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getSUCCESS() {
        return SUCCESS;
    }

    public void setSUCCESS(int SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    public com.example.pawan.retrofitlogin.Model.UsersVisitors getUsersVisitors() {
        return UsersVisitors;
    }

    public void setUsersVisitors(com.example.pawan.retrofitlogin.Model.UsersVisitors usersVisitors) {
        UsersVisitors = usersVisitors;
    }
}

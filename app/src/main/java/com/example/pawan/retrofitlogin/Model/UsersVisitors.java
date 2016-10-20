package com.example.pawan.retrofitlogin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pawan on 10/14/2016.
 */

public class UsersVisitors {


    String user_visitors_emailId;

    String user_visitors_mobile;
    int user_visitor_id;
    String user_visitors_fname;
    int user_visitors_native_location_id;
    int user_visitors_current_location_id;
    String user_visitors_created_on;
    int user_visitors_active;

    public String getUser_visitors_emailId() {
        return user_visitors_emailId;
    }

    public void setUser_visitors_emailId(String user_visitors_emailId) {
        this.user_visitors_emailId = user_visitors_emailId;
    }

    public int getUser_visitor_id() {
        return user_visitor_id;
    }

    public void setUser_visitor_id(int user_visitor_id) {
        this.user_visitor_id = user_visitor_id;
    }

    public String getUser_visitors_mobile() {
        return user_visitors_mobile;
    }

    public void setUser_visitors_mobile(String user_visitors_mobile) {
        this.user_visitors_mobile = user_visitors_mobile;
    }

    public String getUser_visitors_fname() {
        return user_visitors_fname;
    }

    public void setUser_visitors_fname(String user_visitors_fname) {
        this.user_visitors_fname = user_visitors_fname;
    }

    public int getUser_visitors_native_location_id() {
        return user_visitors_native_location_id;
    }

    public void setUser_visitors_native_location_id(int user_visitors_native_location_id) {
        this.user_visitors_native_location_id = user_visitors_native_location_id;
    }

    public int getUser_visitors_current_location_id() {
        return user_visitors_current_location_id;
    }

    public void setUser_visitors_current_location_id(int user_visitors_current_location_id) {
        this.user_visitors_current_location_id = user_visitors_current_location_id;
    }

    public String getUser_visitors_created_on() {
        return user_visitors_created_on;
    }

    public void setUser_visitors_created_on(String user_visitors_created_on) {
        this.user_visitors_created_on = user_visitors_created_on;
    }

    public int getUser_visitors_active() {
        return user_visitors_active;
    }

    public void setUser_visitors_active(int user_visitors_active) {
        this.user_visitors_active = user_visitors_active;
    }
}

package com.example.pawan.retrofitlogin.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pawan.retrofitlogin.Constant.Constants;
import com.example.pawan.retrofitlogin.Interface.RequestInterface;
import com.example.pawan.retrofitlogin.Model.ServerRequest;
import com.example.pawan.retrofitlogin.Model.UsersVisitors;
import com.example.pawan.retrofitlogin.R;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by pawan on 10/20/2016.
 */
public class Register extends AppCompatActivity {
    EditText etname;
    EditText etemail;
    EditText etmobile;
    EditText etnt1;
    EditText etnt2;
    Button reg;
    String sname;
    String semail;
    String smobile;
    int snv1;
    int snv2;
    int success;
    int ss;
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }).create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etname = (EditText) findViewById(R.id.edtname);
        etemail = (EditText) findViewById(R.id.edtemail);
        etmobile = (EditText) findViewById(R.id.edtmobile);
        etnt1 = (EditText) findViewById(R.id.edtnv1);
        etnt2 = (EditText) findViewById(R.id.edtnv2);
        reg = (Button) findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                sname = etname.getText().toString();
                semail = etemail.getText().toString();
                smobile = etmobile.getText().toString();
                snv1 = Integer.parseInt(etnt1.getText().toString());
                snv2 = Integer.parseInt(etnt2.getText().toString());

                RegisterUsers(sname, semail, smobile, snv1, snv2);
            }
        });

    }

    public void RegisterUsers(String sname, String semail, String smobile, int snv1, int snv2) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.selfenabler.com/VoiceOfHeart/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface service = retrofit.create(RequestInterface.class);
        ServerRequest serverRequest = new ServerRequest();
        UsersVisitors usersvisitors = new UsersVisitors();
        usersvisitors.setUser_visitors_fname(sname);
        usersvisitors.setUser_visitors_emailId(semail);
        usersvisitors.setUser_visitors_mobile(smobile);
        usersvisitors.setUser_visitors_current_location_id(snv1);
        usersvisitors.setUser_visitors_native_location_id(snv2);
        serverRequest.setUsersVisitors(usersvisitors);

        Call<List<ServerRequest>> call = service.registerUser
                (usersvisitors.getUser_visitors_fname(), usersvisitors.getUser_visitors_emailId(), usersvisitors.getUser_visitors_mobile(),  usersvisitors.getUser_visitors_current_location_id(), usersvisitors.getUser_visitors_native_location_id());

        call.enqueue(new Callback<List<ServerRequest>>() {
            @Override
            public void onResponse(Response<List<ServerRequest>> response, Retrofit retrofit) {
                List<ServerRequest> sr = response.body();
                Log.e("my", sr.toString());
                String mm = response.message();
                Log.e("bbody", mm);


                for (int i = 0; i < sr.size(); i++) {
                    Log.e("size", sr.size() + "");

                    String userid = sr.get(i).getMESSAGE();
                     ss=sr.get(i).getSUCCESS();

                    Log.e("sssuuu",userid);
                   // String uu = sr.get(i).getUsersVisitors().getUser_visitors_fname();
                    success = sr.get(i).getSUCCESS();
                    //int id = sr.get(i).getScheme_active();
                    //Log.e("uu", uu + "");
                    //String title = sr.get(i).getScheme_title();
                    //String body = sr.get(i).getScheme_weblink();
                    //Log.e("result", userid + "   " + id + "  " + title + "   " + body);

                }



            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }
}

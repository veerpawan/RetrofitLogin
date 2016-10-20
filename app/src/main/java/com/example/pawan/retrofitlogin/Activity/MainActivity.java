package com.example.pawan.retrofitlogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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


public class MainActivity extends AppCompatActivity {


    public Button btn_login;
    public EditText et_email, et_password;
    public ProgressBar progress;
    public SharedPreferences pref;
    TextView tv;
    String email;
    String password;
    int success;
    TextView tvreg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getPreferences(0);

        btn_login = (Button) findViewById(R.id.btn_login);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        tv = (TextView) findViewById(R.id.textView1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
                finish();
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                email = et_email.getText().toString();
                Log.e("eemail", email);
                password = et_password.getText().toString();
                Log.e("ppasw", password);
                loginProcess(email, password);
            }
        });

    }


    private void loginProcess(String email, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.selfenabler.com/VoiceOfHeart/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface service = retrofit.create(RequestInterface.class);
        ServerRequest serverRequest = new ServerRequest();
        UsersVisitors usersvisitors = new UsersVisitors();
        usersvisitors.setUser_visitors_emailId(email);
        usersvisitors.setUser_visitors_mobile(password);
        serverRequest.setUsersVisitors(usersvisitors);

        Call<List<ServerRequest>> call = service.login(usersvisitors.getUser_visitors_emailId(), usersvisitors.getUser_visitors_mobile());

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
                    String uu = sr.get(i).getUsersVisitors().getUser_visitors_fname();
                    success = sr.get(i).getSUCCESS();
                    //int id = sr.get(i).getScheme_active();

                    Log.e("uu", uu + "");
                    //String title = sr.get(i).getScheme_title();
                    //String body = sr.get(i).getScheme_weblink();
                    //Log.e("result", userid + "   " + id + "  " + title + "   " + body);

                }
                if (success == 1) {
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();
                    /*Intent i=new Intent(getApplicationContext(),Register.class);
                    startActivity(i);
                    finish();*/
                } else {

                    Toast.makeText(MainActivity.this, "not", Toast.LENGTH_LONG).show();
                }


            }


            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, "not", Toast.LENGTH_LONG).show();
            }
        });
       /* Call<List<ServerRequest>> call = service.getrequest();

        call.enqueue(new Callback<List<ServerRequest>>() {
            @Override
            public void onResponse(Response<List<ServerRequest>> response, Retrofit retrofit) {
                Log.e("answ", String.valueOf(response.body()));
                List<ServerRequest> sr = response.body();
                for (int i = 0; i < sr.size(); i++) {m
                    Log.e("size", sr.size() + "");

                    String userid = sr.get(i).getMESSAGE();
                    //int id = sr.get(i).getScheme_active();
                    Log.e("uu", userid+"");
                    //String title = sr.get(i).getScheme_title();
                    //String body = sr.get(i).getScheme_weblink();
                    //Log.e("result", userid + "   " + id + "  " + title + "   " + body);

                }
                Log.e("rrespo", response.message());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("ffailed", t.toString());
                tv.setText("no ne");

            }
        });
*/

    }


    //Log.d("rreq", requestInterface.toString());


        /*UsersVisitors usersvisitors1 = new UsersVisitors();
        usersvisitors1.setUser_visitors_emailId(et_email.getText().toString());
        usersvisitors1.setUser_visitors_mobile(et_password.getText().toString());
        ServerRequest request = new ServerRequest();
        *///request.setUsersvisitors(usersvisitors1);
    // request.setSUCCESS(Constants.SUCCESS);


    //Call<ServerResponse> response = requestInterface.getUsersVisitors(request);

          /*  @Override
            public void onResponse(Call<List<ServerRequest>> call, Response<List<ServerRequest>> response) {
                try {
                    List<ServerRequest> StudentData = response.body();

                    String a = response.message();
                    Log.e("rreso", a.toString());




                }catch(Exception e)
                {

                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<ServerRequest>> call, Throwable t) {

            }
*/


}



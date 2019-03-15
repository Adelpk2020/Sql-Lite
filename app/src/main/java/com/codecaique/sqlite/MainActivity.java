package com.codecaique.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codecaique.sqlite.Database.User;

public class MainActivity extends AppCompatActivity {

    EditText et_fname ;
    EditText et_lname ;
    EditText et_mail ;
    EditText et_phone ;
    EditText et_pass ;
    EditText et_add ;
    Button btn_signup ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        et_fname = (EditText)findViewById(R.id.et_fname);
        et_lname = (EditText)findViewById(R.id.et_lname);
        et_mail = (EditText)findViewById(R.id.et_mail);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_pass = (EditText)findViewById(R.id.et_password);
        et_add = (EditText)findViewById(R.id.et_address);
        btn_signup = (Button)findViewById(R.id.btn_signup);


    }


    public void on_signup(View view) {
        String fname = et_fname.getText().toString();
        String lname = et_lname.getText().toString();
        String mail = et_mail.getText().toString();
        String phone = et_phone.getText().toString();
        String pass = et_pass.getText().toString();
        String add = et_add.getText().toString();

        if(phone.equals(""))
        {
            et_phone.setError("required");
        }
        User user = new User(this);
        user.insert(fname,lname,mail,phone,pass,add);
    }

    public void on_select(View view) {
        Intent i = new Intent(this , SelectActivity.class);
        startActivity(i);
    }
}

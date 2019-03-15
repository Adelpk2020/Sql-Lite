package com.codecaique.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.codecaique.sqlite.Database.User;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {


    ListView lv_users;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        arrayList = new ArrayList<String>();
        lv_users = (ListView)findViewById(R.id.lv_users);

        try {
            User u = new User(this);
            Cursor c = u.select();

            c.moveToFirst();
            while (c.moveToNext()) {
                String id = c.getString(0);
                String f_name = c.getString(1);
                arrayList.add(id + "\n" + f_name);
            }

            for(String y : arrayList){
                Toast.makeText(this, y, Toast.LENGTH_LONG).show();
            }

            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , android.R.id.text1, arrayList);


            lv_users.setAdapter(arrayAdapter);

        }catch (Exception e){
            Toast.makeText(this, "error 504\n"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

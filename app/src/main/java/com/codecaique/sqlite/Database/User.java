package com.codecaique.sqlite.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.Toast;

public class User extends SQLiteOpenHelper {

    Context context;
    public User(Context context) {
        super(context, "users" , null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table `users` (`id` integer primary key autoincrement  , `f_name Text` , `l_name` Text , `mail` Text , `phone` Text , `password` Text , `address` Text  )");
    }

    public void insert(String fName , String lName , String email , String ph , String pass, String add){
        try {
            SQLiteDatabase dbc = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("f_name", fName);
            cv.put("l_name", lName);
            cv.put("mail", email);
            cv.put("phone", ph);
            cv.put("password", pass);
            cv.put("address", add);

            dbc.insert("users", null, cv);

            Toast.makeText(context, "insert success", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this.context, "error 201\n"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public Cursor select(){
        try {
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor c = db.rawQuery("select * from `users`", null);


            return c;
        }catch (Exception e){
            Toast.makeText(context, "error 804\n"+e.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }








    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.rabinovich.myapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = getApplicationContext();
        //AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "LoginDatabase").build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logIn(View view){

        TextView textEmail = (TextView) findViewById(R.id.emailText);

        context = getApplicationContext();
        if(checkEmail(textEmail)){

            sharedPreferences = context.getSharedPreferences(
                    getString(R.string.preference_file_name), Context.MODE_PRIVATE);

            editor = sharedPreferences.edit();
            editor.putString(getString(R.string.email_key), textEmail.getText().toString()).commit();

            Toast logInToast = Toast.makeText(context, "Logged in", Toast.LENGTH_SHORT);
            logInToast.show();
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }else{
            Toast WrongEmailtToast = Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT);
            WrongEmailtToast.show();
        }
    }

    private boolean checkEmail(TextView textView){
        boolean isEmail = false;
        for (int i = 0; i < textView.getText().length(); i++){
            if (textView.getText().charAt(i) == '@'){
                isEmail = true;
            }
        }
        return isEmail;
    }
}

package com.example.rabinovich.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logIn(View view){
        
        TextView textEmail = (TextView) findViewById(R.id.emailText);

        if(checkEmail(textEmail)){
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }else{
            Toast toast = Toast.makeText(context, "email not valid", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private boolean checkEmail(TextView textView){
        boolean isEmail = false;
        for (int i = 0; i < textView.getText().length(); i++){
            if (textView.getText().charAt(i) == '@') isEmail = true;
        }
        return isEmail;
    }
}

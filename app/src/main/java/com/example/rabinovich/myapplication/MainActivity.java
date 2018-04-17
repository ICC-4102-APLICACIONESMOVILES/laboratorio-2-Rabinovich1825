package com.example.rabinovich.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private DrawerLayout drawerLayout;
    private boolean logedIn;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TextView userText;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);

        context = getApplicationContext();

        sharedPreferences = context.getSharedPreferences(
                getString(R.string.preference_file_name), Context.MODE_PRIVATE);

        String email = sharedPreferences.getString("email", "");

        editor = sharedPreferences.edit();


        if(email.toString() == "") {
            logedIn = false;
        }else logedIn = true;

        userText = (TextView) findViewById(R.id.userText);
        logInButton = (Button) findViewById(R.id.loginMainButton);

        userText.setText(email);

        if(logedIn){;
            logInButton.setText("Log out");
        }else{
            logInButton.setText("Log in");
        }

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        if(menuItem.getItemId() == R.id.nav_form) {
                            FormFragment fragment = new FormFragment();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.content_frame, fragment).commit();
                        }else if (menuItem.getItemId() == R.id.nav_form_counter){
                            BlankFragment blankFragment = new BlankFragment();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.content_frame, blankFragment).commit();
                        }else if (menuItem.getItemId() == R.id.nav_form_done){

                        }
                        // For example, swap UI fragments here
                        return true;
                    }
                });

        drawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openLogin(View view){
        if (logedIn){
            logInButton = (Button) findViewById(R.id.loginMainButton);
            logInButton.setText("Log in");
            userText = (TextView) findViewById(R.id.userText);
            userText.setText("");
            editor.putString(getString(R.string.email_key), "").commit();
            logedIn = false;
        }else{
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }
    }
}

package com.example.app3ratlla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.app3ratlla.fragments.FraRegister;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnRegister;
    EditText ETUsername, ETContra;
    FrameLayout fragmentContainer;


    private boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.frame_layout);
        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.register);
        ETUsername = findViewById(R.id.username);
        ETContra = findViewById(R.id.contraseña);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, startmenu.class);
                i.putExtra("username",ETUsername.getText().toString());
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed) {
                    FraRegister fragment = new FraRegister();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frame_layout, fragment);
                    fragmentTransaction.commit();
                    ETUsername.setEnabled(false);
                    ETContra.setEnabled(false);

                    isFragmentDisplayed = true;
                } else {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentById(R.id.frame_layout);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                    ETUsername.setEnabled(true);
                    ETContra.setEnabled(true);

                    isFragmentDisplayed = false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent i = new Intent(MainActivity.this, settings.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
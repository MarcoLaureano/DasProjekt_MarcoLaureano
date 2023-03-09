package com.example.app3ratlla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class startmenu extends AppCompatActivity {
    TextView getUsername;
    ImageButton btnLocal, btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startmenu);

        getUsername = findViewById(R.id.username);
        getUsername.setText(getIntent().getStringExtra("username"));


        btnLocal = findViewById(R.id.local);
        btnLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(startmenu.this, localgame.class);
                startActivity(i);
            }
        });

        btnRanking = findViewById(R.id.ranking);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(startmenu.this, ranking.class);
                a.putExtra("username", getUsername.getText().toString());
                startActivity(a);
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
                Intent i = new Intent(startmenu.this, settings.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

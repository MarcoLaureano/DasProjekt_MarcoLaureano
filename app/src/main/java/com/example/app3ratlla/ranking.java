package com.example.app3ratlla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app3ratlla.clases.Adapter;
import com.example.app3ratlla.clases.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ranking extends Activity {

    TextView usernameRank;
    ListView ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        usernameRank = findViewById(R.id.username);
        String username = getIntent().getStringExtra("username");
        usernameRank.setText(username);

        List<User> users = new ArrayList<>();
        users.add(new User(R.drawable.profile,"User1", 500));
        users.add(new User(R.drawable.profile,"User2", 700));
        users.add(new User(R.drawable.profile,"User3",  900));

        Collections.sort(users);

        ranking= findViewById(R.id.list_leaderboard);
        Adapter adapter = new Adapter(this, R.layout.list_items, users);
        ranking.setAdapter(adapter);

    }
}
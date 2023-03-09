package com.example.app3ratlla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class localgame extends AppCompatActivity implements View.OnClickListener {

    private Button[][] btns = new Button[3][3];
    private boolean p1first = true;
    private int rounds;
    private int p1points;
    private int p2points;

    private TextView textPlayer1;
    private TextView textPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localgame);

        textPlayer1 = findViewById(R.id.player1);
        textPlayer2 = findViewById(R.id.player2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++){
                String botonsID = "button_" + i + j;
                int resId = getResources().getIdentifier(botonsID, "id", getPackageName());
                btns[i][j] = findViewById(resId);
                btns[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });


    }
    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if(p1first){
            ((Button) view).setText("X");
            ((Button) view).setBackgroundResource(R.drawable.x_bg);
        } else {
            ((Button) view).setText("O");
            ((Button) view).setBackgroundResource(R.drawable.o_bg);

        }

        rounds++;

        if(checkGanador()) {
            if(p1first){
                p1Gana();
            } else {
                p2Gana();
            }
        } else if (rounds == 9){
            empate();
        } else {
            p1first = !p1first;
        }
    }

    private boolean checkGanador() {
        String[][] camps = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                camps[i][j] = btns[i][j].getText().toString();
            }
        }

        for(int i = 0; i < 3; i++){
            if (camps[i][0].equals(camps[i][1])
                    && camps[i][0].equals(camps[i][2])
                    && !camps[i][0].equals("")){
                return true;
            }
        }

        for(int i = 0; i < 3; i++){
            if (camps[0][i].equals(camps[1][i])
                    && camps[0][i].equals(camps[2][i])
                    && !camps[0][i].equals("")){
                return true;
            }
        }

        if (camps[0][0].equals(camps[1][1])
                && camps[0][0].equals(camps[2][2])
                && !camps[0][0].equals("")){
            return true;
        }

        if (camps[0][2].equals(camps[1][1])
                && camps[0][2].equals(camps[2][0])
                && !camps[0][2].equals("")){
            return true;
        }
        return false;
    }

    private void p1Gana() {
        p1points++;
        Toast.makeText(this, "Gana Jugador 1", Toast.LENGTH_SHORT).show();
        actualizaPunts();
        resetTabla();
    }
    private void p2Gana() {
        p2points++;
        Toast.makeText(this, "Gana Jugador 2", Toast.LENGTH_SHORT).show();
        actualizaPunts();
        resetTabla();
    }
    private void empate() {
        Toast.makeText(this,"Empate!", Toast.LENGTH_SHORT).show();
        resetTabla();
    }

    private void actualizaPunts() {
        textPlayer1.setText("Player 1:" + p1points);
        textPlayer2.setText("Player 2:" + p2points);
    }

    private void resetTabla() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btns[i][j].setText("");
                btns[i][j].setBackgroundResource(android.R.drawable.btn_default);
            }
        }
        rounds = 0;
        p1first = true;
    }

    private void resetGame() {
        p1points = 0;
        p2points = 0;
        actualizaPunts();
        resetTabla();
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
                Intent i = new Intent(localgame.this, settings.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

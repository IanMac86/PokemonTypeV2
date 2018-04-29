package com.example.ian.poketype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class pickMenu extends AppCompatActivity {

    Button button, button2, button3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pick_menu);


        button = (Button) findViewById(R.id.buttonType);
        button2 = (Button) findViewById(R.id.buttonDex);
        button3 = (Button) findViewById(R.id.buttonTeam);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(pickMenu.this,
                        typeChart.class);
                startActivity(myIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(pickMenu.this,
                        PokeDex.class);
                startActivity(myIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(pickMenu.this,
                        Teams.class);
                startActivity(myIntent);
            }
        });
    }
    }




//   @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_pick_menu, menu);
//        return true;
   // }


package com.example.ian.poketype;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        openPickMenu();


    }

    public void openPickMenu() {

        button = (Button) findViewById(R.id.MyButton);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
//
//                startActivity(new Intent(MainActivity.this, pickMenu.class));
//

                Intent myIntent = new Intent(MainActivity.this,
                        pickMenu.class);
                startActivity(myIntent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}





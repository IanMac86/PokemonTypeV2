package com.example.ian.poketype;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Teams extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);

        final TextView pokemon1 = (TextView) findViewById(R.id.editTextNumber1);
        final TextView pokemon2 = (TextView) findViewById(R.id.editTextNumber2);
        final TextView pokemon3 = (TextView) findViewById(R.id.editTextNumber3);
        final TextView pokemon4 = (TextView) findViewById(R.id.editTextNumber4);
        final TextView pokemon5 = (TextView) findViewById(R.id.editTextNumber5);
        final TextView pokemon6 = (TextView) findViewById(R.id.editTextNumber6);
        Button btn = (Button) findViewById(R.id.buttonCreateTeam);

        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Teams.this);
            // .setView()
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.alertdialog_custom_view,null);

            builder.setCancelable(false);

            builder.setView(dialogView);

            Button btn_positive = (Button) dialogView.findViewById(R.id.dialog_positive_btn);
            Button btn_negative = (Button) dialogView.findViewById(R.id.dialog_negative_btn);
            final EditText pokemon_name1 = (EditText) dialogView.findViewById(R.id.pokemon_name);
            final EditText pokemon_name2 = (EditText) dialogView.findViewById(R.id.pokemon_name);
            final EditText pokemon_name3 = (EditText) dialogView.findViewById(R.id.pokemon_name);
            final EditText pokemon_name4 = (EditText) dialogView.findViewById(R.id.pokemon_name);
            final EditText pokemon_name5 = (EditText) dialogView.findViewById(R.id.pokemon_name);
            final EditText pokemon_name6 = (EditText) dialogView.findViewById(R.id.pokemon_name);


            final AlertDialog dialog = builder.create();

            btn_positive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();

                        String name1 = pokemon_name1.getText().toString();
                        Toast.makeText(getApplication(),
                                "Submitted Pokemon : " + name1, Toast.LENGTH_SHORT).show();

                        pokemon1.setText(">" + name1 + "");


                    String name2 = pokemon_name2.getText().toString();
                        Toast.makeText(getApplication(),
                            "Submitted Pokemon : " + name2, Toast.LENGTH_SHORT).show();

                         pokemon2.setText(">" + name2 + "");

                    String name3 = pokemon_name3.getText().toString();
                        Toast.makeText(getApplication(),
                                "Submitted Pokemon : " + name3, Toast.LENGTH_SHORT).show();

                        pokemon3.setText(">" + name3 + "");

                    String name4 = pokemon_name4.getText().toString();
                        Toast.makeText(getApplication(),
                                "Submitted Pokemon : " +  name4, Toast.LENGTH_SHORT).show();

                        pokemon4.setText(">" +  name4 + "");

                    String name5 = pokemon_name5.getText().toString();
                        Toast.makeText(getApplication(),
                                "Submitted Pokemon : " + name5, Toast.LENGTH_SHORT).show();

                        pokemon5.setText(">" + name5 + "");

                    String name6 = pokemon_name6.getText().toString();
                        Toast.makeText(getApplication(),
                                "Submitted Pokemon : " + name6, Toast.LENGTH_SHORT).show();

                        pokemon6.setText(">" + name6 + "");
                }
            });



            btn_negative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Dismiss/cancel the alert dialog
                    //dialog.cancel();
                    dialog.dismiss();
                    Toast.makeText(getApplication(),
                            "No button clicked", Toast.LENGTH_SHORT).show();
                }
            });
            //new DialogInterface.OnClickListener() {
                        //public void onClick(DialogInterface dialog, int id) {
//
//                            final EditText editTextNumber1 = new EditText(Teams.this);
//                            final EditText editTextNumber2 = new EditText(Teams.this);
//                            final EditText editTextNumber3 = new EditText(Teams.this);
//                            final EditText editTextNumber4 = new EditText(Teams.this);
//                            final EditText editTextNumber5 = new EditText(Teams.this);
//                            final EditText editTextNumber6 = new EditText(Teams.this);
//
//
//                            editTextNumber1.setInputType(InputType.TYPE_CLASS_TEXT);
//                            editTextNumber2.setInputType(InputType.TYPE_CLASS_TEXT);
//                            editTextNumber3.setInputType(InputType.TYPE_CLASS_TEXT);
//                            editTextNumber4.setInputType(InputType.TYPE_CLASS_TEXT);
//                            editTextNumber5.setInputType(InputType.TYPE_CLASS_TEXT);
//                            editTextNumber6.setInputType(InputType.TYPE_CLASS_TEXT);
//
                            // pokemon1 = editTextNumber1.getText().toString();


            dialog.show();
        }
    });
}
}



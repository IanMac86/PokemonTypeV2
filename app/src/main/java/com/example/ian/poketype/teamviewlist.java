package com.example.ian.poketype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class teamviewlist extends AppCompatActivity {

    private String[] pokemonData = new String[4];
    private DatabaseReference mDatabase;
    private PokeDex pokeObject = new PokeDex();

    Button addPokemonButton;
    Button deletePokemonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamviewlist);

        addPokemonButton = (Button)findViewById(R.id.addPokemon_Button);
        deletePokemonButton = (Button)findViewById(R.id.deletePokemon_Button);

        Bundle bundle = getIntent().getExtras();

        pokemonData = (String[]) bundle.get("pokemonData");

        pokeObject = new PokeDex(pokemonData[0],pokemonData[1],pokemonData[2],pokemonData[3],pokemonData[4]);

        addPokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addPokemonButton(dexID);

            }
        });

        deletePokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePokemonButton(dexID);
            }
        });
        TextView list_id = (TextView)findViewById(R.id.list_id);
        TextView list_name = (TextView)findViewById(R.id.list_name);
        TextView list_type1 = (TextView)findViewById(R.id.list_type1);
        TextView list_type2 = (TextView)findViewById(R.id.list_type2);
        ImageView list_image = (ImageView)findViewById(R.id.list_image);

        id.setText(pokemonData[0]);
        name.setText(pokemonData[1]);
        type1.setText(pokemonData[2]);
        type2.setText(pokemonData[3]);
        image.setTag(pokemonData[4]);
     new DownloadImagesTask().execute(image);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Saved Team").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (PokeDexid == null) {
                            Toast.makeText(teamviewlist.this,"Error could not get id", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.hasChild(PokeDexid)) {
                            addPokemonButton.setBackgroundResource(R.drawable.added_icon);
                            setDeleteEnabled(true);
                        }
                        else {
                            deletePokemonButton.setBackgroundResource(R.drawable.add_icon);
                            setDeleteEnabled(false);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }


    public void onClickAddAmiibo(final String PokeDexid) {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Saved Amiibos").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // [START_EXCLUDE]
                        if (PokeDexid == null) {
                            Toast.makeText(teamviewlist.this,"Error could not fetch Pokemon", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.hasChild(PokeDexid)) {
                            Toast.makeText(teamviewlist.this,"This pokemon is already in Team", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            addPokemon(PokeDexid);
                        }

//                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("getPokemon:onCancelled", databaseError.toException());
                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
        // [END single_value_read]
    }


    public void addAmiibo(String amiiboID) {

        mDatabase = FirebaseDatabase.getInstance().getReference("Saved team/"+ amiiboID);
        mDatabase.setValue(pokeObject);

        Toast.makeText(this, "Pokemon Added to Team", Toast.LENGTH_SHORT).show();

        addPokemonButton.setBackgroundResource(R.drawable.added_icon);


    }

    public void deleteAmiibo(String amiiboID) {

        mDatabase = FirebaseDatabase.getInstance().getReference("Saved pokemon/"+ amiiboID);
        mDatabase.removeValue();

        Toast.makeText(this, "pokemon Removed from Team", Toast.LENGTH_SHORT).show();

        addPokemonButton.setBackgroundResource(R.drawable.add_icon);
    }

    private void setDeleteEnabled(boolean enabled) {
        if (enabled) {
            deletePokemonButton.setVisibility(View.VISIBLE);
        } else {
            deletePokemonButton.setVisibility(View.GONE);
        }
    }

}


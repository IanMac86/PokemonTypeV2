package com.example.ian.poketype;

/**
 * Created by 20075133 on 25/04/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{

    Context mContext;
    ArrayList<Pokemon> pokemons = new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<Pokemon> pokemons) {
        mContext = context;
        this.pokemons = pokemons;
    }


    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Object getItem(int i) {
        return pokemons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.listdexview, viewGroup, false);
        }

        Pokemon Poke = (Pokemon) getItem(i);



        TextView list_id = (TextView)view.findViewById(R.id.list_id);
        TextView list_name = (TextView)view.findViewById(R.id.list_name);
        TextView list_type1 = (TextView)view.findViewById(R.id.list_type1);
        TextView list_type2 = (TextView)view.findViewById(R.id.list_type2);
        ImageView list_image = (ImageView) view.findViewById(R.id.list_image);

        list_id.setText(Poke.getId());
        list_name.setText(Poke.getName());
        list_type1.setText(Poke.getType1());
        list_type2.setText(Poke.getType2());

        String img1 = pokemons.get(i).getSmallImg();

        list_image.setTag(img1);
        new DownloadImagesTask().execute(list_image);



        return view;
    }
}



package com.example.ian.poketype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 20075133 on 27/04/2018.
 */

public class CustomAdapter2 extends BaseAdapter {

    Context pContext;
    ArrayList<Types> poketypes = new ArrayList<>();

    public CustomAdapter2(Context context, ArrayList<Types> poketypes) {
        pContext = context;
        this.poketypes = poketypes;
    }


    @Override
    public int getCount() {
        return poketypes.size();
    }

    @Override
    public Object getItem(int i) {
        return poketypes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(pContext).inflate(R.layout.listviewtypes, viewGroup, false);
        }

        Types poke2 = (Types) getItem(i);



        TextView list_Type = (TextView)view.findViewById(R.id.list_Type);
        TextView list_Strongtypes = (TextView)view.findViewById(R.id.list_Strongtypes);
        TextView list_Weaktypes = (TextView)view.findViewById(R.id.list_Weaktypes);
        TextView list_Strtype1 = (TextView)view.findViewById(R.id.list_Strtype1);
        TextView list_Strtype2 = (TextView)view.findViewById(R.id.list_Strtype2);
        TextView list_Strtype3 = (TextView)view.findViewById(R.id.list_Strtype3);
        TextView list_Strtype4 = (TextView)view.findViewById(R.id.list_Strtype4);
        TextView list_Strtype5 = (TextView)view.findViewById(R.id.list_Strtype5);
        TextView list_Strtype6 = (TextView)view.findViewById(R.id.list_Strtype6);
        TextView list_Weaktype1 = (TextView)view.findViewById(R.id.list_Weaktype1);
        TextView list_Weaktype2 = (TextView)view.findViewById(R.id.list_Weaktype2);
        TextView list_Weaktype3 = (TextView)view.findViewById(R.id.list_Weaktype3);
        TextView list_Weaktype4 = (TextView)view.findViewById(R.id.list_Weaktype4);
        TextView list_Weaktype5 = (TextView)view.findViewById(R.id.list_Weaktype5);
        TextView list_Weaktype6 = (TextView)view.findViewById(R.id.list_Weaktype6);




        list_Type.setText(poke2.getType());
        list_Strtype1.setText(poke2.getStrtype1());
        list_Strtype2.setText(poke2.getStrtype2());
        list_Strtype3.setText(poke2.getStrtype3());
        list_Strtype4.setText(poke2.getStrtype4());
        list_Strtype5.setText(poke2.getStrtype5());
        list_Strtype5.setText(poke2.getStrtype6());

        list_Weaktype1.setText(poke2.getWeaktype1());
        list_Weaktype2.setText(poke2.getWeaktype2());
        list_Weaktype3.setText(poke2.getWeaktype3());
        list_Weaktype4.setText(poke2.getWeaktype4());
        list_Weaktype5.setText(poke2.getWeaktype5());
        list_Weaktype6.setText(poke2.getWeaktype6());







        return view;
    }
}
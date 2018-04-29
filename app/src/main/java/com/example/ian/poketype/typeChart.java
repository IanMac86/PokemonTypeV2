package com.example.ian.poketype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class typeChart extends AppCompatActivity {

    private ListView listView;
    private RequestQueue mQueue;

    private ArrayList<Types> chart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_chart);

        listView = findViewById(R.id.listview_types);

        mQueue = Volley.newRequestQueue(this);

        chart.clear();
        jsonParse();
    }
    private void jsonParse() {
        String url = "https://pastebin.com/raw/TPgJNi20";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("typechart");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject typechart = jsonArray.getJSONObject(i);


                                String type = typechart.getString("type");


                                JSONObject nestObj = typechart.getJSONObject("Strongtypes");
                                String Strtype1 = nestObj.getString("Strtype1");
                                String Strtype2 = nestObj.optString("Strtype2");
                                String Strtype3 = nestObj.optString("Strtype3");
                                String Strtype4 = nestObj.optString("Strtype4");
                                String Strtype5 = nestObj.optString("Strtype5");
                                String Strtype6 = nestObj.optString("Strtype6");

                                JSONObject nestyObj = typechart.getJSONObject("Weaktypes");
                                String Weaktype1 = nestyObj.getString("Weaktype1");
                                String Weaktype2 = nestyObj.optString("Weaktype2");
                                String Weaktype3 = nestyObj.optString("Weaktype3");
                                String Weaktype4 = nestyObj.optString("Weaktype4");
                                String Weaktype5 = nestyObj.optString("Weaktype5");
                                String Weaktype6 = nestyObj.optString("Weaktype6");


                                if(Strtype2 == null) {
                                    Strtype2 = "";
                                }
                                if(Strtype3 == null) {
                                    Strtype3 = "";
                                }
                                if(Strtype4 == null) {
                                    Strtype4 = "";
                                }
                                if(Strtype5 == null) {
                                    Strtype5 = "";
                                }
                                if(Strtype6 == null) {
                                    Strtype6 = "";
                                }
                                if(Weaktype2 == null) {
                                    Weaktype2 = "";
                                }
                                if(Weaktype3 == null) {
                                    Weaktype3 = "";
                                }
                                if(Weaktype4 == null) {
                                    Weaktype4 = "";
                                }
                                if(Weaktype5 == null) {
                                    Weaktype5 = "";
                                }
                                if(Weaktype6 == null) {
                                    Weaktype6 = "";
                                }



                                Types poke2 = new Types(type, Strtype1 , Strtype2, Strtype3, Strtype4, Strtype5, Strtype6, Weaktype1, Weaktype2, Weaktype3, Weaktype4, Weaktype5, Weaktype6);

                                chart.add(poke2);

                                fillListView();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    private void fillListView() {

        CustomAdapter2 myCustomAdapter2 = new CustomAdapter2(typeChart.this, chart);
        listView.setAdapter(myCustomAdapter2);
    }

}

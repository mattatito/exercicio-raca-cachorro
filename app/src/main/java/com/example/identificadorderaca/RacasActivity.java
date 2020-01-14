package com.example.identificadorderaca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class RacasActivity extends AppCompatActivity {


    private TextView lblRaca;
    private ListView listView;
    private String subRaca;
    private String raca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        raca = intent.getStringExtra("raca");
        subRaca = intent.getStringExtra("subRaca");

        //TextView
        lblRaca = findViewById(R.id.lblRaca);
        lblRaca.setText(raca);

        listView = findViewById(R.id.listaSubRaca);

        Log.e("asdads",subRaca);

        ArrayList<String> subRacas = new ArrayList<>();

        String[] racas = subRaca.split(",");

        for(int i = 0; i<racas.length;i++){
            subRacas.add(racas[i]);
            Log.e("RAÇAS",racas[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subRacas);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String subRaca = listView.getItemAtPosition(position).toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("subRaca",subRaca);

                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });


    }



}

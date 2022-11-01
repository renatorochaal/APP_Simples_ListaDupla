package com.example.aula_01_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    protected ListView listalocais;

    private final String[] localidades = {
            "Goiânia", "Goiás", "Anápolis", "Rio Verde", "Jataí", "Catalão",
            "Posse", "Goianésia", "Pirenópolis", "Caldas Novas", "Porangatu",
            "Inhumas", "Abadiânia", "Alexânia", "Cocalzinho", "Itumbiara"
    };

    private final String[] regioes = {
            "Central", "Oeste", "Central", "Sudoeste", "Sudoeste", "Sudeste",
            "Nordeste", "Noroeste", "Central", "Sul", "Norte",
            "Central", "Nordeste", "Nordeste", "Central", "Sul"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listalocais = findViewById(R.id.listaLocais);

        ArrayList<Map<String, Object>> itemsDaLista = new ArrayList<>();
        for(int i=0; i<localidades.length; i++){
            Map<String, Object> item = new HashMap<>();
            item.put("Cidade", localidades[i]);
            item.put("Regiao", regioes[i]);
            itemsDaLista.add(item); //arraylist
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this, itemsDaLista, android.R.layout.simple_list_item_2,
                new String[]{"Cidade", "Regiao"}, new int[]{android.R.id.text1,android.R.id.text2}
        );
        listalocais.setAdapter(adapter);

        listalocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object itemMapa = adapterView.getAdapter().getItem(i);
                Toast.makeText(getApplicationContext(),itemMapa.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
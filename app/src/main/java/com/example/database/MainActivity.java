package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    GranieDatabase granieDatabase;
    EditText editTextNazwa;
    EditText editTextMin;
    EditText editTextMax;
    Button buttonDodaj;
    Spinner spinnerKategoria;
    Button buttonWypisz;
    EditText editTextLiczbaGraczy;
    ListView listView;
    ArrayAdapter<Planszowka> adapter;
    List<Planszowka> szukaneGry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        granieDatabase = GranieDatabase.zwrocInstancjeBazy(getApplicationContext());
        buttonDodaj = findViewById(R.id.buttonDodajDoBazy);
        editTextNazwa = findViewById(R.id.editTextTextNazwaPlanszowki);
        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        spinnerKategoria = findViewById(R.id.spinnerKategoria);
        buttonWypisz = findViewById(R.id.buttonWypisz);
        editTextLiczbaGraczy = findViewById(R.id.editTextLiczbaGraczy);
        listView = findViewById(R.id.listView);



        Planszowka planszowka1 = new Planszowka("Monopoly", 2, 6, "strategiczna");
        Planszowka planszowka2 = new Planszowka("Munchkin", 3, 6, "karciana");
        Planszowka planszowka3 = new Planszowka("Szachy", 2, 2, "strategiczna");
        Planszowka planszowka4 = new Planszowka("Rummikub", 2, 4, "logiczna");
        Planszowka planszowka5 = new Planszowka("Bierki", 2, 4, "logiczna");
        Planszowka planszowka6 = new Planszowka("Connect 4", 2, 2, "logiczna");

        //granieDatabase.uzyjPlanszowkaDao().wstawDoBazyKilka(planszowka1, planszowka2, planszowka3, planszowka4, planszowka5, planszowka6);

        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nazwa = editTextNazwa.getText().toString();
                        int min = Integer.valueOf(editTextMin.getText().toString());
                        int max = Integer.valueOf(editTextMax.getText().toString());
                        String kategoria = spinnerKategoria.getSelectedItem().toString();
                        Planszowka p = new Planszowka(nazwa, min, max, kategoria);
                        granieDatabase.uzyjPlanszowkaDao().wstawDoBazy(p);
                    }
                }
        );

        buttonWypisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int liczbaGraczy = Integer.valueOf(editTextLiczbaGraczy.getText().toString());
                        szukaneGry = granieDatabase.uzyjPlanszowkaDao()
                                .wypiszPlanszowkiWedlugLiczbyGraczy(liczbaGraczy);
                        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,szukaneGry);
                        listView.setAdapter(adapter);
                    }
                }
        );

    }
}
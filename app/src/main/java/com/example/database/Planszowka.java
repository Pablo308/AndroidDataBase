package com.example.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "planszowki")
public class Planszowka {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_planszowki")
    private int id;
    @ColumnInfo(name = "nazwa_planszowki")
    private String nazwa;
    private int minLiczbaGraczy;
    private int maxLiczbaGraczy;
    private String kategoria;


    public Planszowka(String nazwa, int minLiczbaGraczy, int maxLiczbaGraczy, String kategoria) {
        id = 0;
        this.nazwa = nazwa;
        this.minLiczbaGraczy = minLiczbaGraczy;
        this.maxLiczbaGraczy = maxLiczbaGraczy;
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getMinLiczbaGraczy() {
        return minLiczbaGraczy;
    }

    public void setMinLiczbaGraczy(int minLiczbaGraczy) {
        this.minLiczbaGraczy = minLiczbaGraczy;
    }

    public int getMaxLiczbaGraczy() {
        return maxLiczbaGraczy;
    }

    public void setMaxLiczbaGraczy(int maxLiczbaGraczy) {
        this.maxLiczbaGraczy = maxLiczbaGraczy;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}

package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlanszowkaDAO {
    @Insert
    public void wstawDoBazy(Planszowka planszowka);
    @Insert
    public void wstawDoBazyKilka(Planszowka ... planszowkas);
    @Query("SELECT * FROM planszowki")
    public List<Planszowka> wypiszWszystkiePlanszowki();
    @Query("SELECT * FROM planszowki WHERE minLiczbaGraczy<=:liczbaGraczy and maxLiczbaGraczy>=:liczbaGraczy")
    public List<Planszowka> wypiszPlanszowkiWedlugLiczbyGraczy(int liczbaGraczy);
}
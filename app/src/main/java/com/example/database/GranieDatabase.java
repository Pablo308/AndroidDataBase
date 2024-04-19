package com.example.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Planszowka.class}, version = 1)
public abstract class GranieDatabase extends RoomDatabase {

    private static GranieDatabase instancja;

    public abstract PlanszowkaDAO uzyjPlanszowkaDao();

    public static GranieDatabase zwrocInstancjeBazy(Context context){
        if (instancja == null){
            instancja = Room.databaseBuilder(
                    context.getApplicationContext(),
                    GranieDatabase.class,
                    "granie_db"
            ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instancja;
    }
}

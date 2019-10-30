package com.example.roomtest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = (Word.class),version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTENCE;

    public static WordDatabase getINSTENCE(Context context) {
        if(INSTENCE==null)
        {
            INSTENCE = Room.databaseBuilder(context.getApplicationContext(),WordDatabase.class,"my_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTENCE;
    }

    public abstract WordDao getWordDao();
}

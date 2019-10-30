package com.example.roomtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertWord(Word... words);
    @Delete
    void deleteWord(Word... words);
    @Update
    void updateWord(Word... words);
    @Query("select * from Word order by id desc;")
    LiveData<List<Word>> selectWord();
    @Query("delete from word")
    void cleanAllWord();
}

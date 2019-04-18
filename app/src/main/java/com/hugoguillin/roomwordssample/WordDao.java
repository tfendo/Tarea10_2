package com.hugoguillin.roomwordssample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Word palabra);

    @Query("DELETE FROM tabla_palabras")
    void deleteAll();

    @Query("SELECT * from tabla_palabras ORDER BY palabra ASC")
    List<Word> getAllWords();
}

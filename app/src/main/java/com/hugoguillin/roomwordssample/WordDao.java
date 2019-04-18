package com.hugoguillin.roomwordssample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word palabra);

    @Query("DELETE FROM tabla_palabras")
    void deleteAll();

    @Query("SELECT * from tabla_palabras ORDER BY palabra ASC")
    LiveData<List<Word>> getAllWords();

    @Query("SELECT * from tabla_palabras LIMIT 1")
    Word[]getAnyWord();

    @Delete
    void deleteWord(Word palabra);
}

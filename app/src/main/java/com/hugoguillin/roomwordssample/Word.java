package com.hugoguillin.roomwordssample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tabla_palabras")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Palabra")
    private String palabra;

    public Word(@NonNull String palabra){
        this.palabra = palabra;
    }

    public String getPalabra(){
        return palabra;
    }
}

package com.hugoguillin.roomwordssample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository repository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
        allWords = repository.getAllWords();
    }


    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word){
        repository.insert(word);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void deleteWord(Word palabra){
        repository.deleteWord(palabra);
    }
}

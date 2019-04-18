package com.hugoguillin.roomwordssample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao palabra;
    private LiveData<List<Word>> allWords;

    WordRepository(Application app){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(app);
        palabra = db.wordDao();
        allWords = palabra.getAllWords();
    }

    public void insert(Word word){
        new insertAsyncTask(palabra).execute(word);
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void deleteAll(){
        new deleteAllWordsAsyncTask(palabra).execute();
    }

    public void deleteWord(Word word){
        new deleteWordAsyncTask(palabra).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDao asyncTaskDao;

        insertAsyncTask(WordDao dao){
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            asyncTaskDao.insert(words[0]);
            return null;
        }
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void>{

        private WordDao dao;

        deleteAllWordsAsyncTask(WordDao wordDao){
            dao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }

    private static class deleteWordAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDao dao;

        deleteWordAsyncTask(WordDao wordDao){
            dao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            dao.deleteWord(words[0]);
            return null;
        }
    }
}
